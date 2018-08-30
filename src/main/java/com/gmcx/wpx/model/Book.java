package com.gmcx.wpx.model;

/**
 * Created by wpx on 2017/8/7.
 */
public class Book extends BaseModel{

    private int book_Id;
    private int user_Id;
    private String book_Name;
    private double book_Price;

    public int getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(int book_Id) {
        this.book_Id = book_Id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getBook_Name() {
        return book_Name;
    }

    public void setBook_Name(String book_Name) {
        this.book_Name = book_Name;
    }

    public double getBook_Price() {
        return book_Price;
    }

    public void setBook_Price(double book_Price) {
        this.book_Price = book_Price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_Id=" + book_Id +
                ", user_Id=" + user_Id +
                ", book_Name='" + book_Name + '\'' +
                ", book_Price=" + book_Price +
                '}';
    }
}
