package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		/**
		 * 第一步：加载驱动
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/**
		 * 第二步：创建连接
		 */
		String url = "jdbc:mysql://localhost:3306/lottery";
		try {
			conn = DriverManager.getConnection(url, "root", "127857");
			System.out.println("创建连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * 第三部：创建Statement对象
		 */
		try {
			stmt = conn.createStatement();
			System.out.println("创建Statement对象成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * 第四步：发送sql语句
		 * 发送DQL语句
		 * stmt.executeQuery(sql);
		 * 返回值类型为java.sql.ResultSet结果集
		 * ResultSet 遍历原理与Iterator迭代器相似
		 */
		String sql = "select empno,ename,job from emp order by empno desc";
		try {
			rs = stmt.executeQuery(sql);
			//查看结果集中的数据
			while(rs != null && rs.next()){
//				int empno = rs.getInt(1);
//				String ename = rs.getString(2);
//				String job = rs.getString(3);

				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");

				System.out.println("编号：" + empno + "\t姓名：" + ename + "\t职位：" + job);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * 第五步：释放资源，关闭连接
		 * 先打开的后关闭，后打开的先关闭
		 */
		finally{
			try {
				if(rs != null){
					rs.close();
					System.out.println("ResultSet对象关闭成功");
				}
				if(stmt != null){
					stmt.close();
					System.out.println("Statement对象关闭成功！");
				}
				if(conn != null){
					conn.close();
					System.out.println("Connection对象关闭成功！");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
