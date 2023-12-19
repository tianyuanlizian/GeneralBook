package edu.nf.generalbook.controller.admin;

import edu.nf.generalbook.entity.Admin;
import edu.nf.generalbook.entity.Business;
import edu.nf.generalbook.service.admin.AdminService;
import edu.nf.generalbook.service.business.BusinessService;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.vo.PageVO;
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

    private AdminService service;
    private EsService esService;
    @Autowired
    public void setService(AdminService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @GetMapping("/liatAdmin")
    public PageVO<List<Admin>> listAdmin(Integer page, Integer limit){
        PageVO<List<Admin>> vo = service.listAdmin(page, limit);
        return vo;
    }

    @PostMapping("/addAdmin")
    public void addAdmin(String adName, String account, String password){
        Admin admin = new Admin();
        admin.setAdName(adName);
        admin.setAccount(account);
        admin.setPassword(password);
        admin.setState("1");
        service.addAdmin(admin);
    }

    @GetMapping("/updAdminStart")
    public void updAdminStart(Integer adId, String state){
       service.updAdminState(adId,state);
    }

    @GetMapping("/delAdmin")
    public void delAdmin(Integer adId){
        service.delAdmin(adId);
    }
}
