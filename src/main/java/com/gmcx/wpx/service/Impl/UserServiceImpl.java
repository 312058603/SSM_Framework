package com.gmcx.wpx.service.Impl;

import com.gmcx.wpx.dao.BookDao;
import com.gmcx.wpx.dao.UserDao;
import com.gmcx.wpx.service.UserService;
import com.gmcx.wpx.model.User;
import com.gmcx.wpx.model.UserToBooks;
import com.gmcx.wpx.model.UserToRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wpx on 2017/8/3.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private BookDao bookDao;

    public int insertUserToBooks(UserToBooks userToBooks){
        User user = new User();
        user.setUser_Name(userToBooks.getUser_Name());
        user.setUser_Age(userToBooks.getUser_Age());
        int count=userDao.insertUser(user);
        Map<String, Object> map1 = new HashMap<String, Object>();
        int count1 = 0;
        for (int i = 0; i < userToBooks.getBookList().size(); i++) {
            map1.put("user_Id", user.getUser_Id());
            map1.put("book_Name", userToBooks.getBookList().get(i).getBook_Name());
            map1.put("book_Price", userToBooks.getBookList().get(i).getBook_Price());
            int tempCount = bookDao.insertBook(map1);
            count1 += tempCount;
        }
        return count+count1;
    }

    public int insertUser(User user) {
        return 0;
    }

    public int insertUserList(List<User> userList) {
        int count =userDao.insertUserList(userList);
        return count;
    }

    public int deleteUser(User user) {
        int count=userDao.deleteUser(user);
        return count;
    }

    public int updateUser(User user) {
        int count=userDao.updateUser(user);
        return count;
    }

    public User selectUser(int user_Id) {
        User user=userDao.selectUser(user_Id);
        return user;
    }

    public UserToBooks selectUserToBooks(int user_Id) {
        UserToBooks userToBooks=userDao.selectUserToBooks(user_Id);
        return userToBooks;
    }

    public UserToRole selectUserToRole(int user_Id) {
        UserToRole userToRole=userDao.selectUserToRole(user_Id);
        return userToRole;
    }

}
