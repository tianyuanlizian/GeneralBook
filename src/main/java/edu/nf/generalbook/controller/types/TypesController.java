package edu.nf.generalbook.controller.types;

import edu.nf.generalbook.doc.TypesDoc;
import edu.nf.generalbook.doc.UserDoc;
import edu.nf.generalbook.entity.Types;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.service.types.TypesService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 9:44
 */
@RestController
@Slf4j
public class TypesController {

    private TypesService service;
    private EsService esService;
    @Autowired
    public void setService(TypesService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @GetMapping("/listTypes")
    public PageVO<List<Types>> listTypes(Integer page, Integer limit){
        PageVO<List<Types>> vo = service.listTypes(page, limit);
        return vo;
    }

    @PostMapping("/addTypes")
    public void addTypes(String name){
        service.addTypes(name);
    }

    @PostMapping("/delTypes")
    public void delTypes(Integer tid){
        service.delTypes(tid);
    }

    @GetMapping("/selectTypes")
    public PageVO<List<UserDoc>> selectUser(String param, Integer page, Integer limit){
        String[] fields = {"name"};
        List<TypesDoc> list = esService.boolSearch(TypesDoc.class, param, fields);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }
    @GetMapping("/typesList")
    public PageVO<List<Types>> typesList(){
        List<Types> list = service.typesList();
        PageVO vo = new PageVO();
        vo.setData(list);
        return vo;
    }
}
