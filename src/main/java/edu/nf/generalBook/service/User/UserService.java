package edu.nf.generalBook.service.User;

import edu.nf.generalBook.entity.User;
import edu.nf.generalBook.vo.PageVO;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 11:08
 */
public interface UserService {
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
    PageVO<List<User>> listUser(Integer pageNum, Integer pageSize);

}
