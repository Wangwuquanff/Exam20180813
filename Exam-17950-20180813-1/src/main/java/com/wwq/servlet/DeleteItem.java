package com.wwq.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.annotation.WebServlet;

@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String jdbcDriver = "com.mysql.jdbc.Driver";// mysql连接驱动,无需改
	public static String jdbcUrl = "jdbc:mysql://localhost:3306/sakila";
	public static String jdbcUser = "root";//数据库用户名
	public static String jdbcPwd = "root";//数据库密码
	private static Connection conn;
	public static Statement st;
	static {
		try {

			Class.forName(jdbcDriver);// 加载mysql驱动类
			conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPwd);
			// 驱动利用驱动地址，数据库用户名，密码创建连接
			st = conn.createStatement();
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		
		PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		
	    String xuhao = (String)request.getParameter("Fid");
	    System.out.println(xuhao);
	    int flag = 0;
		List<Map> list =new ArrayList<Map>();//创建list集合用于存入map的键值对集合
		try {
			String sql ="delete from film where film_id="+xuhao;
			flag = st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("跳转");
		if(flag == 1) {
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
	}

}
