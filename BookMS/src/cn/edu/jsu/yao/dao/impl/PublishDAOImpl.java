package cn.edu.jsu.yao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.jsu.yao.dao.PublishIDAO;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.Publish;

/**
 * 数据层，出版社数据操作
 * @author 86181
 *
 */
public class PublishDAOImpl implements PublishIDAO{
	private Connection conn;
    public PublishDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public boolean doCreate(Publish publish) {
		if(find(publish.getPublisName())||findId(publish.getPublisId()))
			return false;
		String sql="insert into publish(publishId,publishName,leader,sex)  values (?,?,?,?)";
		try{
			PreparedStatement pstmt;
			pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1,publish.getPublisId());
			pstmt.setString(2, publish.getPublisName());
			pstmt.setString(3,publish.getLeader() );
			pstmt.setString(4, publish.getSex());
			int n=pstmt.executeUpdate();
			System.out.println("影响了多少行:"+n);
			if(n==0)
				return false;
		} catch (SQLException e) {
			System.out.println("添加失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Vector<Publish> get() {
		Vector<Publish> publish=new Vector<Publish>();
		String sql="select * from publish";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				publish.add(new Publish(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publish;
	}

	@Override
	public boolean find(String publisName) {
		String sql="select * from publish";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(2).equals(publisName)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public boolean findId(String publisId) {
		String sql="select * from publish";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(1).equals(publisId)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public Vector<String> getPublisName() {
		Vector<String> publish=new Vector<String>();
		String sql="select * from publish";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				publish.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publish;
	}
}
