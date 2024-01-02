package edu.nf.generalbook.service.collect;

import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.entity.Collect;
import edu.nf.generalbook.vo.PageVO;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 15:05
 **/
public interface CollectService {
    /**
     * 查询全部的收藏的商品并分页
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @return
     */
    PageVO<List<Collect>> listCollect(Integer pageNum, Integer pageSize);

    /**
     * 收藏一个新商品
     * @param collect
     */
    void addCollect(Collect collect);

    /**
     * 根据ID删除收藏的商品
     * @param id
     */
    void delCollect(Integer id);
}
