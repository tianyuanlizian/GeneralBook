package edu.nf.generalBook.service.commodity;

import edu.nf.generalBook.entity.Commodity;
import edu.nf.generalBook.vo.PageVO;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 19:16
 */
public interface CommodityService {
    /**
     * 查询全部商品并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageVO<List<Commodity>> listCommodity(Integer pageNum, Integer pageSize);

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

    PageVO<List<Commodity>> commodityList();

    PageVO<List<Commodity>> listCommodityByType(Integer tid);

    Commodity listCommodityById(Integer bid);

}
