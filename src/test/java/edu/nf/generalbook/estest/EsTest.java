package edu.nf.generalbook.estest;

import edu.nf.generalbook.doc.UserDoc;
import edu.nf.generalbook.service.es.EsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author：tianyuan
 * @Date：2023/12/5 15:03
 */
@SpringBootTest
public class EsTest {

    @Autowired
    private EsService service;

    @Test
    void createIndexTest(){
        service.createIndex(UserDoc.class);
    }
}
