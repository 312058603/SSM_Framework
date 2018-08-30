package com.gmcx.wpx.dao;

import com.gmcx.wpx.model.User;
import com.gmcx.wpx.model.UserToBooks;
import com.gmcx.wpx.model.UserToRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wpx on 2017/8/1.
 */
@Repository
public interface UserDao {

    public int insertUser(User user);

    public int insertUserList(List<User> userList);

    public int deleteUser(User user);

    public int updateUser(User user);

    public User selectUser(int user_Id);

    public UserToBooks selectUserToBooks(int user_Id);

    public UserToRole selectUserToRole(int user_Id);

}
