package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.Types;
import edu.nf.generalbook.entity.User;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 9:01
 */
public interface TypesDao {
    /**
     * 添加类型
     * @param name
     */
    void addTypes(String name);

    /**
     * 根据id删除类型
     * @param id
     */
    void delTypes(Integer id);

    /**
     * 查询所有类型并分页
     * @return
     */
    List<Types> listTypes(Integer pageNum, Integer pageSize);

    /**
     * 查询类型总数量
     * @return
     */
    Long count();

    List<Types> typesList();
}
