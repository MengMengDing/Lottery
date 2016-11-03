package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 将工具类改成无需创建对象即可使用
 *
 *
 */
public class DBUtil {

	//驱动类名
	private static final String className = "com.mysql.jdbc.Driver";
	//连接数据库的字符串url
	private static final String url = "jdbc:mysql://localhost:3306/test";
	//数据库用户名
	private static final String user = "root";
	//连接数据库的密码
	private static final String password = "root";
	//私有化构造方法，不让用户创建该类的对象
	private DBUtil(){}
	/*
	 * 将注册驱动写在静态块中
	 */
	static{
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
	public static Connection getConnection(){
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
	private static void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
                System.out.println("Connection对象关闭");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭Statement对象
	 */
	public static void closeStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
				System.out.println("Statement对象关闭");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭ResultSet对象
	 */
	public static void closeResultSet(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
				System.out.println("ResultSet对象关闭");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭PreparedStatement对象
	 */
	public static void closePreparedStatement(PreparedStatement pstmt){
		try {
			if(pstmt != null){
				pstmt.close();
				pstmt = null;
				System.out.println("PreparedStatement对象关闭");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 一次关闭三个对象
	 */
//	public static void closeAll(Connection conn,Statement stmt,ResultSet rs){
//		closeResultSet(rs);
//		closeStatement(stmt);
//		closeConnection(conn);
//	}
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		closeResultSet(rs);
		closePreparedStatement(pstmt);
		closeConnection(conn);
	}
}
