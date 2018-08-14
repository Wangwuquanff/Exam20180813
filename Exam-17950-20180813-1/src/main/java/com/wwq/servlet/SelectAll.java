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


@WebServlet("/SelectAll")
public class SelectAll extends HttpServlet{
	
	/**
	 * 
	 */
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
		List<Map> list =new ArrayList<Map>();//����list�������ڴ���map�ļ�ֵ�Լ���
		try {
			String sql ="SELECT film.film_id,film.title,film.description,language.name\r\n" + 
					"FROM film,language\r\n" + 
					"where film.language_id=language.language_id;";
			ResultSet rs = st.executeQuery(sql);
			//�����ݿ��ȡ�����ݣ�����һ���������
			System.out.println("��ȡ����");
			while (rs.next()) {
				String FilmId = String.valueOf(rs.getInt("film_id"));
				String Title = rs.getString("title");
				String Description = rs.getString("description");
				String Name = rs.getString("name");
				//��ȡ��ѭ���������ݿ�ı����Ϣ
				Map map = new HashMap(); 
				map.put("filmid", FilmId);			
				map.put("title", Title);		
				map.put("description", Description);
				map.put("name", Name);
				//�ü�ֵ�Դ��뵽map������
				System.out.println(map);
				list.add(map);//�ڽ�map���϶������list����
//				System.out.println("���뼯��");
//				for (Map map_1 :list) {
//					System.out.println(map_1);
//				}//�ڴ�ӡ̨���������ݲ鿴�Ƿ��д���

			}//���������

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��ת");
		request.setAttribute("key_list",list);//��list�������ݷ��뵽request�й���
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		//��ת��index.jspҳ��
	}
}
