package edu.nf.generalbook.addressInfo;

import edu.nf.generalbook.dao.AddressInfoDao;
import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.service.addressInfo.AddressInfoService;
import edu.nf.generalbook.service.admin.AdminService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 09:33
 **/
@SpringBootTest
@Slf4j
public class AddressInfoTest {
    @Autowired
    private AddressInfoService service;
    @Autowired
    private AddressInfoDao dao;
    @Test
    void listAddressInfo(){
        PageVO<List<AddressInfo>> vo = service.listAddressInfo(1, 5);
        List<AddressInfo> addressInfos = vo.getData();
        addressInfos.forEach(addressInfo -> {
            log.info(addressInfo.toString());
        });
    }

    @Test
    void addAddressInfo(){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAName("ssdb");
        addressInfo.setAddress("广东珠海");
        addressInfo.setPhone("123346562");
        addressInfo.setUId(1);
        service.addAddressInfo(addressInfo);
    }

    @Test
    void updAddressInfo(){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setAId(1);
        addressInfo.setAName("骚骚的别");
        addressInfo.setAddress("广东珠海");
        addressInfo.setPhone("123346562");
        addressInfo.setUId(1);
        service.updAddressInfo(addressInfo);
    }
    @Test
    void delAddressInfo(){
        service.delAddressInfo(2);
    }
}
