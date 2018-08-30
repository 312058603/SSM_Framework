package com.gmcx.wpx.model;

import java.util.List;

/**
 * Created by wpx on 2017/8/7.
 */
public class UserToBooks extends User{

    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "UserToBooks{" +
                "user_Id=" + user_Id +
                ", user_Name='" + user_Name + '\'' +
                ", bookList=" + bookList +
                ", user_Age=" + user_Age +
                '}';
    }

}
