package edu.nf.generalBook.service.collect.impl;

import edu.nf.generalBook.dao.CollectDao;
import edu.nf.generalBook.entity.Collect;
import edu.nf.generalBook.entity.Commodity;
import edu.nf.generalBook.service.collect.CollectService;
import edu.nf.generalBook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 15:07
 **/
@Slf4j
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Service
public class CollectServiceImpl implements CollectService {
    private final CollectDao dao;
    @Override
    public PageVO<List<Collect>> listCollect(Integer pageNum, Integer pageSize) {
        List<Collect> list = dao.listCollect(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }

    @Override
    public void addCollect(Collect collect) {
        dao.addCollect(collect);
    }

    @Override
    public void delCollect(Integer id) {
        dao.delCollect(id);
    }

    @Override
    public PageVO<List<Commodity>> listCollectByUId(Integer uid) {
        List<Collect> collects = dao.listCollectByUId(uid);
        List<Commodity> list = new ArrayList();
        collects.forEach(collect -> {
            list.add(collect.getCommodity());
        });
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(collects.stream().count());
        return vo;
    }

    @Override
    public void delCollectById(Integer uid, Integer bid) {
        dao.delCollectById(uid, bid);
    }
}
