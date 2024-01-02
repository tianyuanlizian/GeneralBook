package edu.nf.generalbook.service.login;

import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.vo.PageVO;
import jakarta.servlet.http.HttpSession;

/**
 * @Author: tianyuan
 * @Date: 2024/1/2 10:38
 **/
public interface LoginService {
    /**
     * 根据用户账号查询用户
     * @param account
     * @return
     */
    PageVO<User> login(HttpSession session, String account, String password);
}
