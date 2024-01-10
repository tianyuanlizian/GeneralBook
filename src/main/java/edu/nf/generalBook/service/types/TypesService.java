package edu.nf.generalBook.service.types;

import edu.nf.generalBook.entity.Types;
import edu.nf.generalBook.vo.PageVO;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 9:30
 */
public interface TypesService {
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
    PageVO<List<Types>> listTypes(Integer pageNum, Integer pageSize);

    List<Types> typesList();
}
