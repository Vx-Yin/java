package cn.edu.jsu.yao.dbc;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
	//����MySQL���ݿ���������
	private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
	//����MySQL���ݿ����ӵ�ַ��db_library�ɸĳ��Լ������ݿ�����
	private static final String DBURL="jdbc:mysql://localhost:3306/bookms?serverTimezone=UTC";
	private static final String DBUSER="root"; //MySQL���ݿ������û���
	private static final String PASSWORD="123456"; //MySQL���ݿ���������
	private java.sql.Connection conn=null; //�������Ӷ���
	public DatabaseConnection(){//���췽���������ݿ�
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
	public java.sql.Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				conn.close();
				System.out.println("���ݿ��Ѿ��ر�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
