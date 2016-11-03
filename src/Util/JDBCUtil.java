package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 功能：封装连接数据库的方法
 *
 */
public class JDBCUtil {

	//驱动类名
	private static final String className = "com.mysql.jdbc.Driver";
	//连接数据库的字符串url
	private static final String url = "jdbc:mysql://localhost:3306/lottery";
	//数据库用户名
	private static final String user = "root";
	//连接数据库的密码
	private static final String password = "127857";

	/**
	 * 在构造方法中注册驱动
	 */
	public JDBCUtil(){
		/*
		 * 第一步
		 */
		try {
			Class.forName(className);
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Connection对象
	 */
	public Connection getConnection(){
		//声明连接
		Connection conn = null;
		/*
		 * 第二步
		 */
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭Connection对象
	 */
	private void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
				conn = null;
				System.out.println("Connection对象关闭");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭Statement对象
	 */
	private void closeStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
				stmt = null;
				System.out.println("Statement对象关闭");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭ResultSet对象
	 */
	private void closeResultSet(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
				rs = null;
				System.out.println("ResultSet对象关闭");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 一次关闭三个对象
	 */
	public void closeAll(Connection conn,Statement stmt,ResultSet rs){
		closeResultSet(rs);
		closeStatement(stmt);
		closeConnection(conn);
	}
}
