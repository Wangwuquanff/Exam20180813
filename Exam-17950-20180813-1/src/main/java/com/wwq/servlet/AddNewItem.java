package com.wwq.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddNewItem")
public class AddNewItem extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static String jdbcDriver = "com.mysql.jdbc.Driver";// mysql��������,�����
	public static String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
	public static String jdbcUser = "root";//���ݿ��û���
	public static String jdbcPwd = "root";//���ݿ�����
	private static Connection conn;
	public static Statement st;
	static {
		try {

			Class.forName(jdbcDriver);// ����mysql������
			conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPwd);
			// ��������������ַ�����ݿ��û��������봴������
			st = conn.createStatement();
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
	    String xuhao = request.getParameter("xuhao");
	    String miaoshu = request.getParameter("miaoshu");
	    String biaoti = request.getParameter("biaoti");
	    int flag = 0;
		try {
			String sql ="insert into film(title,description,language_id) values('��ѵ','shucsh',1)" ;
			flag = st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��ת");
		if(flag == 1) {
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
	}
	

}
