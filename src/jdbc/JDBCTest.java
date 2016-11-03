package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		//声明连接
		Connection conn = null;
		//声明Statement对象
		Statement stmt = null;
		/*
		  第一步：注册mysql驱动
		  com.mysql.jdbc.Driver是mysql数据库的驱动类
		  写在一个静态代码块
		  当系统调用静态代码块时，向DriverManager驱动管家注册驱动
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/*
		 * 第二步：创建连接
		 * url：就是连接数据库路径
		 * jdbc:mysql://localhost:3306/test
		 * jdbc--表示使用的是jdbc的技术连接
		 * mysql--表示连接的是mysql数据库
		 * localhost:3306 --数据库所在ip地址:端口号
		 * test --mysql中选用的数据库的名称
		 *
		 * user:mysql数据库的用户名
		 * password:mysql数据库的密码
		 */
		String url = "jdbc:mysql://localhost:3306/lottery";
		String user = "root";
		String password = "127857";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功！");
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * 第三步：创建Statement对象
		 * 用Statement对象来发送sql语句到数据库
		 * 可以把Statement对象看成一个容器，传递sql语句，带回执行结果
		 */
		try {
			assert conn != null;
			stmt = conn.createStatement();
			System.out.println("创建Statement对象成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * 第四步：发送sql语句
		 * stmt.executeUpdate(sql);执行给定sql语句
		 * 执行的语句可能为insert,update,delete,create,drop(DDL,DML语句)
		 * 返回值类型为int
		 * 如果返回之为0,则表示执行的是DDL语句或者DML并没有影响到数据表的任何行
		 * 如果返回值不为0，执行的DML语句影响数据表的行数
		 */
		String sql = "insert into emp(empno,ename,job) values(8002,'zhang','meng')";
		try {
			assert stmt != null;
			int returnNum = stmt.executeUpdate(sql);
			if(returnNum == 1){
				System.out.println("插入一行数据成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * 第五步：释放资源，关闭连接
		 * 先打开的后关闭，后打开的先关闭
		 */
		finally{
			try {
				if(stmt != null){
					stmt.close();
					System.out.println("Statement对象关闭成功！");
				}
				conn.close();
				System.out.println("Connection对象关闭成功！");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

















	}

}
