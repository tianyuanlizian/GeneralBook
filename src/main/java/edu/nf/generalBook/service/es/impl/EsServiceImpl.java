package edu.nf.generalBook.service.es.impl;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import edu.nf.generalBook.service.es.EsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/5 11:11
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class EsServiceImpl implements EsService {
    /**
     * 注入ElasticsearchRestTemplate
     */
    private final ElasticsearchOperations operations;

    /**
     * 创建索引
     * @param clazz 文档对象的Class，因为指定了index的名称
     *
     * 先判断索引是否存在，不存在则创建
     */
    public void createIndex(Class<?> clazz) {
        if(!operations.indexOps(clazz).exists()) {
            operations.indexOps(clazz).create();
        }
    }

    /**
     * 删除索引
     * @param clazz
     */
    public void deleteIndex(Class<?> clazz) {
        if(operations.indexOps(clazz).exists()) {
            operations.indexOps(clazz).delete();
        }
    }

    /**
     * 创建mapping
     * @param clazz
     */
    public void putMapping(Class<?> clazz) {
        operations.indexOps(clazz).putMapping();
    }

    /**
     * 创建文档
     * @param user
     */
    public <T> T createDoc(T user) {
        return operations.save(user);
    }

    public boolean docExist(String id, String index) {
        return operations.exists(id, IndexCoordinates.of(index));
    }

    /**
     * 根据id查询文档
     * @param id
     * @param clazz
     * @return
     * @param <T>
     */
    public <T> T getDoc(String id, Class<T> clazz) {
        return operations.get(id, clazz);
    }

    /**
     * 更新文档
     * @param doc
     */
    public void updateDoc(Document doc) {
        //构建UpdateQuery
        UpdateQuery query = UpdateQuery.builder(doc.getId())
                .withDocument(doc).build();
        operations.update(query, IndexCoordinates.of(doc.getIndex()));
    }

    /**
     * 根据id删除文档
     * @param id
     * @param clazz
     */
    public void deleteDoc(String id, Class<?> clazz) {
        operations.delete(id, clazz);
    }

    /**
     * 文档检索
     * @param searchParam 检索参数
     * @param field 检索的字段
     * @param docType 映射对象的Class
     * @return
     * @param <T>
     */
    public <T> List<T> termSearch(String searchParam,
                                  String field, Class<T> docType) {
        //构建本地查询器
        NativeQueryBuilder builder = new NativeQueryBuilder();
        //使用terms查询，指定查询参数和字段
        builder.withQuery(query ->
                        //trem
                        query.term(t -> t.field(field).value(searchParam))
                //match
                //query.match(m -> m.field(field).query(searchParam))
        );
        //如果需要分页，则设置withPageable
        builder.withPageable(PageRequest.of(0, 2));
        //执行检索并返回命中的记录
        SearchHits<T> hits = operations.search(builder.build(), docType);
        //封装到list集合中
        List<T> result = new ArrayList<>();
        hits.forEach(hit -> result.add(hit.getContent()));
        return result;
    }

    /**
     * bool检索
     * @param docType
     * @param searchParam
     * @param fields
     * @return
     * @param <T>
     */
    public <T> List<T> boolSearch(Class<T> docType,
                                  String searchParam,String[] fields) {
        NativeQueryBuilder builder = new NativeQueryBuilder();
        builder.withQuery(q -> {
            //构建布隆查询
            return q.bool(bq -> {
                List<Query> queries = new ArrayList<>();
                //创建should查询集合，应用在多个字段上
                for (String field : fields) {
                    Query query = Query.of(oq -> oq.term(t -> t.field(field).value(searchParam)));
                    //构建多个termQuery查询，保存到list集合中
                    queries.add(query);
                }
                bq.should(queries);
                return bq;
            });
        });
        SearchHits<T> hits = operations.search(builder.build(), docType);
        //封装到list集合中
        List<T> result = new ArrayList<>();
        hits.forEach(hit -> result.add(hit.getContent()));
        return result;
    }

    /**
     * bool查询结合嵌套查询
     * @param docType
     * @param searchParam
     * @param fields
     * @return
     * @param <T>
     */
    public <T> List<T> boolNestedSearch(Class<T> docType, String searchParam, String[] fields) {
        NativeQueryBuilder builder = new NativeQueryBuilder();
        builder.withQuery(q -> {
            //构建布隆查询
            return q.bool(bq -> {
                List<Query> queries = new ArrayList<>();
                //创建should查询集合，应用在多个字段上
                for (String field : fields) {
                    //如果检索的字段是一个复合字段，那么将其分割出要检索的路径
                    if(field.contains(".")) {
                        String nestedPath = field.substring(0, field.lastIndexOf("."));
                        //构建nested查询
                        Query query = Query.of(oq ->
                                oq.nested(nq -> nq.query(tq ->
                                                tq.term(t -> t.field(field).value(searchParam)))
                                        .path(nestedPath)));
                        //将query保存到集合中
                        queries.add(query);
                    } else {
                        //否则构建普通的term查询
                        Query query = Query.of(oq -> oq.term(t -> t.field(field).value(searchParam)));
                        //构建多个termQuery查询，保存到list集合中
                        queries.add(query);
                    }

                }
                bq.should(queries);
                return bq;
            });
        });
        SearchHits<T> hits = operations.search(builder.build(), docType);
        //封装到list集合中
        List<T> result = new ArrayList<>();
        hits.forEach(hit -> result.add(hit.getContent()));
        return result;
    }
}
