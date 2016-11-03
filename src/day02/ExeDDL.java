package day02;

import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试DDL
 * @author Administrator
 *
 */
public class ExeDDL {

    /**
     * 创建表的方法
     */
    public void createTable(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "create table user(userid int primary key auto_increment," +
                "usercode varchar(20),username varchar(15),password varchar(30),flag int,password varchar(512))";

        try {
            //获取Statement对象
            stmt = conn.createStatement();
            //执行sql语句
            int row = stmt.executeUpdate(sql);
            if(row == 0){
                System.out.println("表创建成功");
            }else{
                System.out.println("表创建失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            util.closeAll(conn, stmt, null);
        }
    }

    /**
     * 删除表的方法
     */
    public void dropTable(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "drop table if exists user";

        try {
            //获取Statement对象
            stmt = conn.createStatement();
            //执行sql语句
            int row = stmt.executeUpdate(sql);
            if(row == 0){
                System.out.println("表删除成功");
            }else{
                System.out.println("表删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            util.closeAll(conn, stmt, null);
        }
    }

    public static void main(String[] args) {
        ExeDDL e = new ExeDDL();
        e.createTable();
//		e.dropTable();
    }
}
