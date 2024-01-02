package edu.nf.generalbook.service.login.impl;

import edu.nf.generalbook.dao.UserDao;
import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.service.login.LoginService;
import edu.nf.generalbook.vo.PageVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: tianyuan
 * @Date: 2024/1/2 10:40
 **/
@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final UserDao dao;
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
}
