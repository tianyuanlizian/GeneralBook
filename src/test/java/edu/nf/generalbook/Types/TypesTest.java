package edu.nf.generalbook.Types;

import edu.nf.generalbook.dao.TypesDao;
import edu.nf.generalbook.doc.TypesDoc;
import edu.nf.generalbook.doc.UserDoc;
import edu.nf.generalbook.entity.Types;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.service.types.TypesService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 9:54
 */
@SpringBootTest
@Slf4j
public class TypesTest {
    @Autowired
    private TypesService service;
    @Autowired
    private EsService esService;
    @Autowired
    private TypesDao dao;

    @Test
    void listTypesTest(){
        PageVO<List<Types>> vo = service.listTypes(1, 5);
        List<Types> list = vo.getData();
        list.forEach(types -> {
            log.info(types.getName());
        });
    }

    @Test
    void addTypesTest(){
        service.addTypes("奇幻");
    }

    @Test
    void delTypesTest(){
        service.delTypes(6);
    }


    /**
     * 创建搜索引擎索引
     */
    @Test
    void createIndexTest(){
        esService.createIndex(TypesDoc.class);
    }

    /**
     * 创建mapper
     */
    @Test
    void putMappingTest(){
        esService.putMapping(TypesDoc.class);
    }

    /**
     * 创建文档并同步
     */
    @Test
    void createDocTest(){
        List<Types> list = dao.typesList();
        list.forEach(types -> {
            TypesDoc doc = new TypesDoc(types.getTId(), types.getName());
            esService.createDoc(doc);
        });
    }
    
    /**
     * 布隆查询
     */
    @Test
    void boolSearchTest(){
        String[] fields = {"name"};
        List<TypesDoc> list = esService.boolSearch(TypesDoc.class, "都市", fields);
        list.forEach(typesDoc ->{
            log.info(typesDoc.getName());
            log.info(typesDoc.getTId().toString());
        });
    }
    }
