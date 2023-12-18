package edu.nf.generalbook.controller.business;

import edu.nf.generalbook.entity.Business;
import edu.nf.generalbook.service.business.BusinessService;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.service.notice.NoticeService;
import edu.nf.generalbook.vo.PageVO;
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

    private BusinessService service;
    private EsService esService;
    @Autowired
    public void setService(BusinessService service) {
        this.service = service;
    }
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @GetMapping("/liatBusiness")
    public PageVO<List<Business>> listBusiness(Integer page, Integer limit){
        PageVO<List<Business>> vo = service.listBusiness(page, limit);
        return vo;
    }

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

    @PostMapping("/updBusiness")
    public void updBusiness(Integer buId, String buName, String address, String phone, String email, String picture, String introduce){
        Business business = new Business();
        business.setBuId(buId);
        business.setBuName(buName);
        business.setAddress(address);
        business.setPhone(phone);
        business.setEmail(email);
        business.setPicture(picture);
        business.setIntroduce(introduce);
        service.updBusiness(business);
    }

    @PostMapping("/delBusiness")
    public void delBusiness(Integer buId){
        service.delBusiness(buId);
    }
}
