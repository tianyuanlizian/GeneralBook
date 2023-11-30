package edu.nf.generalbook.service.User;

import edu.nf.generalbook.entity.User;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 11:08
 */
public interface UserService {
    void addUser(User user);

    boolean login(String account, String password);

    void updUser(User user);

    void updUserState(Integer uId, String state);

    List<User> listUser();

}
