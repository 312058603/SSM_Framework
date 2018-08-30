package com.gmcx.wpx.service;

import com.gmcx.wpx.model.User;
import com.gmcx.wpx.model.UserToBooks;
import com.gmcx.wpx.model.UserToRole;

import java.util.List;

/**
 * Created by wpx on 2017/8/3.
 */
public interface UserService {

    public int insertUser(User user);

    public int insertUserList(List<User> userList);

    public int insertUserToBooks(UserToBooks userToBooks);

    public int deleteUser(User user);

    public int updateUser(User user);

    public User selectUser(int user_Id);

    public UserToBooks selectUserToBooks(int user_Id);

    public UserToRole selectUserToRole(int user_Id);

}
