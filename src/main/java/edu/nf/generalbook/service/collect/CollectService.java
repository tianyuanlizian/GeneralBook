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
    PageVO<List<Collect>> listCollect(Integer pageNum, Integer pageSize);

    void addCollect(Collect collect);

    void delCollect(Integer id);
}
