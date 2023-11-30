package edu.nf.generalbook.dao;

import edu.nf.generalbook.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 10:33
 */
public interface UserDao {
    void addUser(User user);

    void updUser(User user);

    void updUserState(String state);

    List<User> listUser();

}
