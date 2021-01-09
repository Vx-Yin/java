package cn.edu.jsu.yao.service.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.jsu.yao.dao.impl.UserDAOImpl;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.service.IUserService;
import cn.edu.jsu.yao.vo.User;
/**
 * 用户有关操作的业务层,实现相关的功能服务
 * @author 尹奥琪
 *
 */
public class UserServiceImpl implements IUserService{
	private DatabaseConnection dbc=null;//建立数据库连接
    public UserServiceImpl() {
		dbc=new DatabaseConnection();
	}
	@Override
	public boolean find(String account) {
		return new UserDAOImpl().find(account);
	}
	@Override
	public boolean register(User user) {
		if(new UserDAOImpl().doCreate(user))
			return false;
		else
			return true;
	}
	@Override
	public int logon(String account,String password) {
		UserDAOImpl dao=new UserDAOImpl();
		return dao.find(account,password);
		
	}
	@Override
	public boolean UpdataPassage(User user, String passage) {
		new UserDAOImpl().doUpdata(user.getAccount(), user.getPassword());
		return false;
	}
	@Override
	public Vector<User> get() {
		return new UserDAOImpl().get();
	}
	public static void main(String[] args) {
		Vector<User> user=new UserServiceImpl().get();
		for(int i=0;i<user.size();i++)
			System.out.println(user.get(i));
	}
}
