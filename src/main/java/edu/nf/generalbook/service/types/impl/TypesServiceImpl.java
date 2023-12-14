package edu.nf.generalbook.service.types.impl;

import edu.nf.generalbook.dao.TypesDao;
import edu.nf.generalbook.entity.Types;
import edu.nf.generalbook.service.types.TypesService;
import edu.nf.generalbook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/12/11 9:33
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class TypesServiceImpl implements TypesService {
    private final TypesDao dao;
    @Override
    public void addTypes(String name) {
        dao.addTypes(name);
    }

    @Override
    public void delTypes(Integer id) {
        dao.delTypes(id);
    }

    @Override
    public PageVO<List<Types>> listTypes(Integer pageNum, Integer pageSize) {
        List<Types> list = dao.listTypes(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }

    @Override
    public List<Types> typesList() {
        List<Types> list = dao.typesList();
        return list;
    }
}
