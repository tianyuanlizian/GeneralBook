package edu.nf.generalbook.controller.collect;

import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.entity.Collect;
import edu.nf.generalbook.entity.Commodity;
import edu.nf.generalbook.service.addressInfo.AddressInfoService;
import edu.nf.generalbook.service.collect.CollectService;
import edu.nf.generalbook.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 16:08
 **/
@RestController
@Slf4j
public class CollectController {
    //收藏功能的service
    private CollectService service;
    //注入
    @Autowired
    public void setService(CollectService service) {
        this.service = service;
    }
    //查询全部收藏的商品
    @GetMapping("/listCollect")
    public PageVO<List<Collect>> listCollect(Integer page, Integer limit){
        PageVO<List<Collect>> vo = service.listCollect(page, limit);
        return vo;
    }
    //收藏一个商品
    @PostMapping("/addCollect")
    public void addCollect(Integer bid,Integer uid){
        Collect collect = new Collect();
        collect.setBId(bid);
        collect.setCreateDate(LocalDateTime.now());
        collect.setUId(uid);
        service.addCollect(collect);
    }
    //根据ID删除收藏的商品
    @PostMapping("/delCollect")
    public void delCollect(Integer coId){
        service.delCollect(coId);
    }

    //根据用户Id查询收藏的商品信息
    @GetMapping("/listCollectByUId")
    public PageVO<List<Commodity>> listCollectByUId(Integer uid){
        PageVO<List<Commodity>> vo = service.listCollectByUId(uid);
        return vo;
    }

    @PostMapping("/delCollectById")
    public PageVO delCollectById(@RequestBody Map<String, Integer> collectData){
        Integer uid = collectData.get("uid");
        Integer bid = collectData.get("bid");

        service.delCollectById(uid, bid);
        PageVO vo = new PageVO();
        vo.setMessage("删除成功");
        return vo;
    }
}
