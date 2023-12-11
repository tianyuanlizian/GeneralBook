package edu.nf.generalbook.service.types;

import edu.nf.generalbook.entity.Types;
import edu.nf.generalbook.vo.PageVO;

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
     * 查询所有类型
     * @return
     */
    PageVO<List<Types>> listTypes(Integer pageNum, Integer pageSize);
}
