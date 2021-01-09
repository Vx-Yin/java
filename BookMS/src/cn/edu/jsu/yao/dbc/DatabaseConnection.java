package cn.edu.jsu.yao.dbc;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
	//定义MySQL数据库驱动程序
	private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
	//定义MySQL数据库连接地址，db_library可改成自己的数据库名称
	private static final String DBURL="jdbc:mysql://localhost:3306/bookms?serverTimezone=UTC";
	private static final String DBUSER="root"; //MySQL数据库连接用户名
	private static final String PASSWORD="123456"; //MySQL数据库连接密码
	private java.sql.Connection conn=null; //保存连接对象
	public DatabaseConnection(){//构造方法连接数据库
		try {
			Class.forName(DBRIVER);
		} catch (Exception e) {e.printStackTrace();}
		try {
			conn= DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public java.sql.Connection getConnection() {//返回数据库连接对象
		return this.conn;
	}
	public void close() {//关闭数据连接
		if(this.conn!=null) {
			try {
				conn.close();
				System.out.println("数据库已经关闭");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
