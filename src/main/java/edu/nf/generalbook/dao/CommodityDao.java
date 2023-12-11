package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.Commodity;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 15:28
 */
public interface CommodityDao {
    /**
     * 查询全部商品并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Commodity> listCommodity(Integer pageNum,Integer pageSize);

    /**
     * 添加商品
     * @param commodity
     */
    void addCommodity(Commodity commodity);

    /**
     * 修改信息
     * @param commodity
     */
    void updCommodity(Commodity commodity);

    /**
     * 修改商品状态
     * @param bId
     * @param state
     */
    void updCommodityState(Integer bId, String state);

    /**
     * 查询总记录数
     * @return
     */
    Long count();

    /**
     * 查询所有商品信息
     * @return
     */
    List<Commodity> commodityList();
}
