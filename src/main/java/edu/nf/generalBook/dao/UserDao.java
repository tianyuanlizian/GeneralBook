package edu.nf.generalBook.dao;

import edu.nf.generalBook.entity.User;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 10:33
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updUser(User user);

    /**
     * 修改用户状态
     * @param uId
     * @param state
     */
    void updUserState(Integer uId, String state);

    /**
     * 查询用户进行分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> listUser(Integer pageNum,Integer pageSize);

    /**
     * 根据用户账号查询用户
     * @param account
     * @return
     */
    User loginUser(String account);

    /**
     * 查询用户总数量
     * @return
     */
    Long count();

    /**
     * 查询所有用户
     * @return
     */
    List<User> userList();

}
