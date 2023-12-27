package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.AddressInfo;
import edu.nf.generalbook.entity.Collect;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/27 09:57
 **/
public interface CollectDao {
    List<Collect> listCollect(Integer pageNum, Integer pageSize);

    void addCollect(Collect collect);

    void delCollect(Integer id);

    Long count();
}
