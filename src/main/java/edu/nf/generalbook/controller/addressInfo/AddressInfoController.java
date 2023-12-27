package edu.nf.generalbook.controller.addressInfo;

import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.entity.OrderGoods;
import edu.nf.generalbook.service.addressInfo.AddressInfoService;
import edu.nf.generalbook.service.es.EsService;
import edu.nf.generalbook.service.ordergoods.OrderGoodsService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 15:57
 **/
@RestController
@Slf4j
public class AddressInfoController {
    private AddressInfoService service;

    @Autowired
    public void setService(AddressInfoService service) {
        this.service = service;
    }

    @GetMapping("/listAddressInfo")
    public PageVO<List<AddressInfo>> listAddressInfo(Integer page, Integer limit){
        PageVO<List<AddressInfo>> vo = service.listAddressInfo(page, limit);
        return vo;
    }

    @PostMapping("/addAddressInfo")
    public void addAddressInfo(String aName, String address, String phone, Integer uid){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAName(aName);
        addressInfo.setAddress(address);
        addressInfo.setPhone(phone);
        addressInfo.setUId(uid);
        service.addAddressInfo(addressInfo);
    }
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

    @PostMapping("/delAddressInfo")
    public void delAddressInfo(Integer aid){
        service.delAddressInfo(aid);
    }
}
