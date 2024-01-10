package edu.nf.generalBook.service.es;

import org.springframework.data.elasticsearch.core.document.Document;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/5 10:04
 */

public interface EsService {

    /**
     * 创建索引
     * @param clazz 文档对象的Class，因为指定了index的名称
     *
     * 先判断索引是否存在，不存在则创建
     */
    void createIndex(Class<?> clazz);

    /**
     * 删除索引
     * @param clazz
     */
    void deleteIndex(Class<?> clazz);

    /**
     * 创建mapping
     * @param clazz
     */
    void putMapping(Class<?> clazz);

    /**
     * 创建文档
     * @param user
     */
    <T> T createDoc(T user);

    /**
     * 根据id判断是否存在
     * @param id
     * @param index
     * @return
     */
    boolean docExist(String id, String index);

    /**
     * 根据id查询文档
     * @param id
     * @param clazz
     * @return
     * @param <T>
     */
    <T> T getDoc(String id, Class<T> clazz);

    /**
     * 更新文档
     * @param doc
     */
    void updateDoc(Document doc);

    /**
     * 根据id删除文档
     * @param id
     * @param clazz
     */
    void deleteDoc(String id, Class<?> clazz);

    /**
     * 文档检索
     * @param searchParam 检索参数
     * @param field 检索的字段
     * @param docType 映射对象的Class
     * @return
     * @param <T>
     */
    <T> List<T> termSearch(String searchParam, String field, Class<T> docType);

    /**
     * bool检索
     * @param docType
     * @param searchParam
     * @param fields
     * @return
     * @param <T>
     */
    <T> List<T> boolSearch(Class<T> docType, String searchParam, String[] fields);

    /**
     * bool查询结合嵌套查询
     * @param docType
     * @param searchParam
     * @param fields
     * @return
     * @param <T>
     */
    <T> List<T> boolNestedSearch(Class<T> docType, String searchParam, String[] fields);
}
