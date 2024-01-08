package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.entity.Collect;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 09:57
 **/
public interface CollectDao {
    /**
     * 查询全部的收藏的商品并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Collect> listCollect(Integer pageNum, Integer pageSize);

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

    /**
     * 查询收藏商品的总数量
     * @return
     */
    Long count();

    List<Collect> listCollectByUId(Integer uid);

    void delCollectById(Integer uid, Integer bid);
}
