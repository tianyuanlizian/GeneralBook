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
    //类型的service
    private TypesService service;
    //搜索引擎
    private EsService esService;
    //注入
    @Autowired
    public void setService(TypesService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }
    //查询全部的类型
    @GetMapping("/listTypes")
    public PageVO<List<Types>> listTypes(Integer page, Integer limit){
        PageVO<List<Types>> vo = service.listTypes(page, limit);
        return vo;
    }
    //添加一种新类型
    @PostMapping("/addTypes")
    public void addTypes(String name){
        service.addTypes(name);
    }
    //根据ID删除类型
    @PostMapping("/delTypes")
    public void delTypes(Integer tid){
        service.delTypes(tid);
    }
    //使用搜索引擎查询类型
    @GetMapping("/selectTypes")
    public PageVO<List<Types>> selectTypes(String param, Integer page, Integer limit){
        String[] fields = {"name"};
        List<TypesDoc> list = esService.boolSearch(TypesDoc.class, param, fields);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }
    //查询全部的类型（不使用分页）
    @GetMapping("/typesList")
    public PageVO<List<Types>> typesList(){
        List<Types> list = service.typesList();
        PageVO vo = new PageVO();
        vo.setData(list);
        return vo;
    }
}
