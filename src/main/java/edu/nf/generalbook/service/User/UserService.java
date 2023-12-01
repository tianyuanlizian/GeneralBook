package edu.nf.generalbook.service.User;

import edu.nf.generalbook.entity.User;
import edu.nf.generalbook.vo.PageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：tianyuan
 * @Date：2023/11/30 11:08
 */
public interface UserService {
    void addUser(User user);

    User login(String account, String password);

    void updUser(User user);

    void updUserState(Integer uId, String state);

    PageVO<List<User>> listUser(Integer pageNum, Integer pageSize);

}
