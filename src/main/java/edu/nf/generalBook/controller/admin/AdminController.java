package edu.nf.generalBook.controller.admin;

import edu.nf.generalBook.entity.Admin;
import edu.nf.generalBook.service.admin.AdminService;
import edu.nf.generalBook.service.es.EsService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 11:13
 **/
@RestController
@Slf4j
public class AdminController {
    //管理员的service
    private AdminService service;
    //搜索引擎
    private EsService esService;
    //注入
    @Autowired
    public void setService(AdminService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    //查询全部管理员信息
    @GetMapping("/liatAdmin")
    public PageVO<List<Admin>> listAdmin(Integer page, Integer limit){
        PageVO<List<Admin>> vo = service.listAdmin(page, limit);
        return vo;
    }
    //添加管理员
    @PostMapping("/addAdmin")
    public void addAdmin(String adName, String account, String password){
        Admin admin = new Admin();
        admin.setAdName(adName);
        admin.setAccount(account);
        admin.setPassword(password);
        admin.setState("1");
        service.addAdmin(admin);
    }
    //根据ID修改管理员信息
    @GetMapping("/updAdminStart")
    public void updAdminStart(Integer adId, String state){
       service.updAdminState(adId,state);
    }

    //根据ID删除管理员
    @GetMapping("/delAdmin")
    public void delAdmin(Integer adId){
        service.delAdmin(adId);
    }
}
