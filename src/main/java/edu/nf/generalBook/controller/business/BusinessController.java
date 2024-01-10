package edu.nf.generalBook.controller.business;

import edu.nf.generalBook.entity.Business;
import edu.nf.generalBook.service.business.BusinessService;
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
 * @Date: 2023/12/18 11:04
 **/
@RestController
@Slf4j
public class BusinessController {
    //商家信息的service
    private BusinessService service;
    //搜索引擎
    private EsService esService;
    //注入
    @Autowired
    public void setService(BusinessService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }
    //查询全部的商家信息
    @GetMapping("/liatBusiness")
    public PageVO<List<Business>> listBusiness(Integer page, Integer limit){
        PageVO<List<Business>> vo = service.listBusiness(page, limit);
        return vo;
    }
    //添加商家信息
    @PostMapping("/addBusiness")
    public void addBusiness(String buName, String address, String phone, String email, String picture, String introduce){
        Business business = new Business();
        business.setBuName(buName);
        business.setAddress(address);
        business.setPhone(phone);
        business.setEmail(email);
        business.setPicture(picture);
        business.setIntroduce(introduce);
        service.addBusiness(business);
    }
    //根据ID修改商家信息
    @PostMapping("/updBusiness")
    public void updBusiness(Integer buId, String buName, String address, String phone, String email, String picture, String introduce){
        Business business = new Business();
        business.setBuId(buId);
        business.setBuName(buName);
        business.setAddress(address);
        business.setPhone(phone);
        business.setEmail(email);        business.setPicture(picture);
        business.setIntroduce(introduce);
        service.updBusiness(business);
    }
    ////根据ID删除商家信息
    @PostMapping("/delBusiness")
    public void delBusiness(Integer buId){
        service.delBusiness(buId);
    }

    @PostMapping ("/imgTest")
    public PageVO<List<Business>> imgTest(){
        PageVO<List<Business>> vo = service.listBusiness(1, 5);
        return vo;
    }
}
