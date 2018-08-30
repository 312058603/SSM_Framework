package com.gmcx.wpx.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wpx on 2017/7/5.
 */
public class TestServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        System.out.println("TestServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet doGet");
        String value=this.getServletContext().getInitParameter("name");
        System.out.println("name对应的值="+value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet doPost");
    }

}
