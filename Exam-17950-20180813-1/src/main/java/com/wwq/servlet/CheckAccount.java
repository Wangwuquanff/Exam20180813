package com.wwq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckAccount extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        AcountBean account = new AcountBean();
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        System.out.println(username);
        System.out.println(pwd);
        boolean isValid = false;
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        PrintWriter printWriter = resp.getWriter();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");// 加载mysql驱动程序
            String url = "jdbc:mysql://localhost:3306/sakila";
            String user = "root";// 用户名,系统默认的账户名
            String pwd2 = "root";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, pwd2);// 获取连接
            // System.out.println("连接成功！");

            String sql = "select * from customer where first_name=?";// 预编译语句，“？”代表参数
            pre = con.prepareStatement(sql);// 实例化预编译语句
            pre.setString(1, username);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            if (result.next()){
                isValid = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                //System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        account.setPassword(pwd);
        account.setUsername(username);
        System.out.println("success");
        session.setAttribute("account", account);
        if(isValid){
            System.out.println("登录成功！");
            session.setAttribute("username", username);
            resp.sendRedirect(req.getContextPath()+"/select.jsp");
            return;
        }else{
            System.out.println("登录成功！");
            resp.sendRedirect(req.getContextPath()+"/fail.jsp");
            return;
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);

    }
}
