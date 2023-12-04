package edu.nf.generalbook.service.User.impl;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.vo.PageVO;
import lombok.RequiredArgsConstructor;
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
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public User login(String account, String password) {
        User user = dao.loginUser(account);
        if (password.equals(user.getPassword())){
            return user;
        }
        throw new RuntimeException("用户"+account+"错误");
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
        vo.setCode(200);
        vo.setData(list);
        vo.setCount(count);
        return vo;
    }
}
