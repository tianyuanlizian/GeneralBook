package edu.nf.generalBook.controller.commodity;

import edu.nf.generalBook.doc.CommodityDoc;
import edu.nf.generalBook.entity.Commodity;
import edu.nf.generalBook.service.commodity.CommodityService;
import edu.nf.generalBook.service.es.EsService;
import edu.nf.generalBook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/13 16:21
 **/
@RestController
@Slf4j
public class CommodityController {
    //商品的service
    private CommodityService service;
    //搜索引擎
    private EsService esService;
    //注入
    @Autowired
    public void setEsService(EsService esService) {
        this.esService = esService;
    }

    @Autowired
    public void setService(CommodityService service) {
        this.service = service;
    }
    //查询全部的商品信息
    @GetMapping("/listCommodity")
    public PageVO<List<Commodity>> listCommodity(Integer page, Integer limit){
        PageVO<List<Commodity>> vo = service.listCommodity(page, limit);
        return vo;
    }
    //添加商品
    @PostMapping("/addCommodity")
    public void addCommodity(String bname, String author, String press, String notes, Integer tId, String issuingDate, String produceDate,
                             String picture, Integer inventory){
        Commodity commodity = new Commodity();
        commodity.setBName(bname);
        commodity.setAuthor(author);
        commodity.setPress(press);
        commodity.setNotes(notes);
        commodity.setTId(tId);
        commodity.setIssuingDate(issuingDate);
        commodity.setProduceDate(LocalDate.parse(produceDate));
        commodity.setPicture(picture);
        commodity.setInventory(inventory);
        commodity.setState("1");
        service.addCommodity(commodity);
    }
    //根据ID修改商品信息
    @PostMapping("/updCommodity")
    public void updCommodity( Integer bId, String bname, String author, String press, String notes, Integer tId, String issuingDate,
                              String produceDate, String picture, Integer inventory){
        Commodity commodity = new Commodity();
        commodity.setBId(bId);
        commodity.setBName(bname);
        commodity.setAuthor(author);
        commodity.setPress(press);
        commodity.setNotes(notes);
        commodity.setTId(tId);
        commodity.setIssuingDate(issuingDate);
        commodity.setProduceDate(LocalDate.parse(produceDate));
        commodity.setPicture(picture);
        commodity.setInventory(inventory);
        commodity.setState("1");
        service.updCommodity(commodity);
    }
    //根据ID修改商品状态
    @GetMapping("/updCommodityState")
    public void updCommodityState(Integer bId,String state){
        service.updCommodityState(bId,state);
    }

    @GetMapping("/commodityList")
    public PageVO<List<Commodity>> commodityList(){
        PageVO<List<Commodity>> vo = service.commodityList();
        return vo;
    }

    @GetMapping("/listCommodityByType")
    public PageVO<List<Commodity>> listCommodityByType(Integer tid){
        PageVO<List<Commodity>> vo = service.listCommodityByType(tid);
        return vo;
    }

    @GetMapping("/listCommodityById")
    public Commodity listCommodityById(Integer bid){
        Commodity commodity = service.listCommodityById(bid);
        return commodity;
    }

    //使用搜索引擎查询用户信息
    @GetMapping("/selectCommodity")
    public PageVO<List<Commodity>> selectCommodity(String param, Integer page, Integer limit){
        String[] fields = {"bName", "author","press"};
        List<CommodityDoc> list = esService.boolSearch(CommodityDoc.class, param, fields);
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(list.stream().count());
        return vo;
    }
}
