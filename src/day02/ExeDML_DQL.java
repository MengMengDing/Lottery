package day02;

import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExeDML_DQL {

    /**
     * 表的增删改查
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExeDML_DQL e = new ExeDML_DQL();
//		e.insert();
//		e.update();
//		e.delete1();
//		e.delete2();
//		e.queryAll();
//		e.queryById();
//		e.queryByUsercode();

        boolean f = e.login("jiading", "123456");

        //sql注入
//		boolean f = e.login("admin", "aa' or '1=1");

        if(f){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码错误，请重新输入");
        }
    }
    /**
     * 保存数据到数据库
     */
    public void insert(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "insert into user(usercode,username,password,flag) values('jiading','zhang','123456',1)";
//		String sql = "insert into user(usercode,username,password,flag) " +
//						"values('lisi','李四','111111',1)," +
//						"('tom','汤姆','222222',1)," +
//						"('jerry','杰瑞','333333',1)";

        try {
            stmt = conn.createStatement();
            int row = stmt.executeUpdate(sql);
            System.out.println(row);
            if(row > 0){
                System.out.println("数据插入成功");
            }else{
                System.out.println("数据插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, null);
        }
    }
    /**
     * 修改数据到数据库
     */
    public void update(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "update user set usercode='chris',username='克里斯',password='000000' where userid=6";

        try {
            stmt = conn.createStatement();
            int row = stmt.executeUpdate(sql);
            if(row > 0){
                System.out.println("数据修改成功");
            }else{
                System.out.println("数据修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, null);
        }
    }
    /**
     * 逻辑删除数据
     */
    public void delete1(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "update user set flag=0 where userid=1";

        try {
            stmt = conn.createStatement();
            int row = stmt.executeUpdate(sql);
            if(row > 0){
                System.out.println("数据删除成功");
            }else{
                System.out.println("数据删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, null);
        }
    }
    /**
     * 逻辑删除数据
     */
    public void delete2(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "delete from user where userid=1";

        try {
            stmt = conn.createStatement();
            int row = stmt.executeUpdate(sql);
            if(row > 0){
                System.out.println("数据删除成功");
            }else{
                System.out.println("数据删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, null);
        }
    }
    /**
     * 查选全部数据
     */
    public void queryAll(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "select userid,usercode,username,password from user where flag=1";
        //声明ResultSet对象
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            //执行sql语句，获取结果集
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while(rs != null && rs.next()){
                int userid = rs.getInt(1);
                String usercode = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                System.out.println("编号：" + userid + " 用户名：" + usercode + " 姓名：" + username + " 密码：" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, rs);
        }
    }
    /**
     * 根据主键查选单条数据
     */
    public void queryById(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "select userid,usercode,username,password from user where flag=1 and userid=6";
        //声明ResultSet对象
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            //执行sql语句，获取结果集
            rs = stmt.executeQuery(sql);
            //遍历结果集
            if(rs != null && rs.next()){
                int userid = rs.getInt(1);
                String usercode = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                System.out.println("编号：" + userid + " 用户名：" + usercode + " 姓名：" + username + " 密码：" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, rs);
        }
    }
    /**
     * 模糊查选
     */
    public void queryByUsercode(){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //定义sql语句
        String sql = "select userid,usercode,username,password from user where usercode like '%i%'";
        //声明ResultSet对象
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            //执行sql语句，获取结果集
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while(rs != null && rs.next()){
                int userid = rs.getInt(1);
                String usercode = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                System.out.println("编号：" + userid + " 用户名：" + usercode + " 姓名：" + username + " 密码：" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, rs);
        }
    }
    /**
     * 模仿登录
     */
    public boolean login(String usercode,String password){
        //实例化JDBCUtil工具类，加载驱动
        JDBCUtil util = new JDBCUtil();
        //获取连接对象
        Connection conn = util.getConnection();
        //声明Statement对象
        Statement stmt = null;
        //声明ResultSet对象
        ResultSet rs = null;
        //定义sql语句
        String sql = "select count(*) from user where flag=1 and usercode='" + usercode +
                "' and password='"+ password +"'";

        System.out.println(sql);
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs!= null && rs.next()){
                int count = rs.getInt(1);
                if(count>0){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            util.closeAll(conn, stmt, rs);
        }

        return false;
    }


}
