package edu.nf.generalbook.service.User.impl;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.User.UserService;
import edu.nf.generalbook.vo.PageVO;
import jakarta.servlet.http.HttpSession;
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
    public PageVO<User> login(HttpSession session, String account, String password) {
        PageVO vo = new PageVO();
        if(account != null && !"".equals(account)){
            User user = dao.loginUser(account);
            if (user != null && password.equals(user.getPassword()) && "1".equals(user.getState())){
                session.setAttribute("user", user);
                vo.setData(user);
                vo.setMessage("登录成功");
            }else if (user == null){
                vo.setMessage("没有该用户");
            }else {
                vo.setMessage("密码错误或者该用户已被封禁");
            }
        }
        return vo;
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
