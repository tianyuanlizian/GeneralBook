package edu.nf.generalbook.service.admin.impl;

import edu.nf.generalbook.dao.AdminDao;
import edu.nf.generalbook.entity.Admin;
import edu.nf.generalbook.service.admin.AdminService;
import edu.nf.generalbook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: tianyuan
 * @Date: 2023/12/19 10:42
 **/
@Slf4j
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminDao dao;

    @Override
    public PageVO<List<Admin>> listAdmin(Integer pageNum, Integer pageSize) {
        List<Admin> list = dao.listAdmin(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }

    @Override
    public void addAdmin(Admin admin) {
        dao.addAdmin(admin);
    }

    @Override
    public void updAdminState(Integer id, String state) {
        dao.updAdminState(id, state);
    }

    @Override
    public void delAdmin(Integer id) {
        dao.delAdmin(id);
    }
}
