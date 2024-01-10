package edu.nf.generalBook.service.User.impl;

import edu.nf.generalBook.dao.UserDao;
import edu.nf.generalBook.entity.User;
import edu.nf.generalBook.service.User.UserService;
import edu.nf.generalBook.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 15:22
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void updUser(User user) {
        dao.updUser(user);
    }

    @Override
    public void updUserState(Integer uId, String state) {
        dao.updUserState(uId,state);
    }

    @Override
    public PageVO<List<User>> listUser(Integer pageNum, Integer pageSize) {
        List<User> list = dao.listUser(pageNum, pageSize);
        Long count = dao.count();
        PageVO vo = new PageVO();
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }
}
