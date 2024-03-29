package edu.nf.generalBook.controller.addressInfo;

import edu.nf.generalBook.entity.AddressInfo;
import edu.nf.generalBook.service.addressInfo.AddressInfoService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 15:57
 **/
@RestController
@Slf4j
public class AddressInfoController {
    //地址的service
    private AddressInfoService service;

    //注入
    @Autowired
    public void setService(AddressInfoService service) {
        this.service = service;
    }

    //查询全部的地址信息
    @GetMapping("/listAddressInfo")
    public PageVO<List<AddressInfo>> listAddressInfo(Integer page, Integer limit){
        PageVO<List<AddressInfo>> vo = service.listAddressInfo(page, limit);
        return vo;
    }

    //添加地址
    @PostMapping("/addAddressInfo")
    public void addAddressInfo(String aName, String address, String phone, Integer uid){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAName(aName);
        addressInfo.setAddress(address);
        addressInfo.setPhone(phone);
        addressInfo.setUId(uid);
        service.addAddressInfo(addressInfo);
    }

    //根据ID修改地址
    @PostMapping("/updAddressInfo")
    public void updAddressInfo(Integer aid,String aName, String address, String phone, Integer uid){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAId(aid);
        addressInfo.setAName(aName);
        addressInfo.setAddress(address);
        addressInfo.setPhone(phone);
        addressInfo.setUId(uid);
        service.updAddressInfo(addressInfo);
    }

    //根据ID删除地址
    @PostMapping("/delAddressInfo")
    public void delAddressInfo(Integer aid){
        service.delAddressInfo(aid);
    }
}
