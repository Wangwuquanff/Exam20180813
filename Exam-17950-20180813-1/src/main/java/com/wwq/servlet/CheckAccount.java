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
        Connection con = null;// ����һ�����ݿ�����
        PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
        ResultSet result = null;// ����һ�����������
        PrintWriter printWriter = resp.getWriter();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");// ����mysql��������
            String url = "jdbc:mysql://localhost:3306/sakila";
            String user = "root";// �û���,ϵͳĬ�ϵ��˻���
            String pwd2 = "root";// �㰲װʱѡ���õ�����
            con = DriverManager.getConnection(url, user, pwd2);// ��ȡ����
            // System.out.println("���ӳɹ���");

            String sql = "select * from customer where first_name=?";// Ԥ������䣬�������������
            pre = con.prepareStatement(sql);// ʵ����Ԥ�������
            pre.setString(1, username);// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
            result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
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
                // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
                // ע��رյ�˳�����ʹ�õ����ȹر�
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                //System.out.println("���ݿ������ѹرգ�");
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
            System.out.println("��¼�ɹ���");
            session.setAttribute("username", username);
            resp.sendRedirect(req.getContextPath()+"/select.jsp");
            return;
        }else{
            System.out.println("��¼�ɹ���");
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
