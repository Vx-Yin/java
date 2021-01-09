package cn.edu.jsu.yao.dao.impl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.edu.jsu.yao.dao.UserIDAO;
import cn.edu.jsu.yao.vo.User;
/**
 * 数据层,用户操作
 * @author 尹奥琪
 *
 */
public class UserDAOImpl implements UserIDAO{
	private File file=new File("data/user");//存数据的文本
	public UserDAOImpl() {}
	@Override
	public boolean doCreate(User user) {
		try (FileWriter fw=new FileWriter(file,true)){
			fw.write(user.getUsername()+'\t'+user.getAccount()+'\t'+user.getPassword()+'\t'+user.getSex()+'\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean doUpdata(String account,String password) {
		Boolean b=false;
		Vector<User> user=get();
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getAccount().equals(account))
				{
				 user.get(i).setPassword(password);
				 b=true;
				}
		}
		try (FileWriter fw=new FileWriter(file,false)){
			for(int i=0;i<user.size();i++)
			fw.write(user.get(i).getUsername()+'\t'+user.get(i).getAccount()+'\t'+user.get(i).getPassword()+'\t'+user.get(i).getSex()+'\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return b;
	}
	@Override
	public int find(String account,String password) {
		String line;//字符串读取
		try (FileReader fr = new FileReader(file);){
			BufferedReader br=new BufferedReader(fr);//使用缓冲流
			while((line=br.readLine())!=null) {
				String[] col=line.split("\t");//拆分为数组,第二个字段为用户，第三个字段为密码，第四个字段判断是否为管理员
				if(col[1].equals(account)) {
					if(col[2].equals(password))
						return 1;
					else
						return 0;
					}
				}
		  } catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return -1;
	}
	@Override
	public Boolean find(String account) {
		String line;//字符串读取
		try (FileReader fr = new FileReader(file);){
			BufferedReader br=new BufferedReader(fr);//使用缓冲流
			while((line=br.readLine())!=null) {
				String[] col=line.split("\t");//拆分为数组,第一个字段为用户，第二个字段为密码
				if(col[1].equals(account)) 
				return true;
				}
		  } catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public Vector<User> get(){
		String line;//字符串读取
		Vector<User> user = new Vector<User>();
		try (FileReader fr = new FileReader(file);){
			BufferedReader br=new BufferedReader(fr);//使用缓冲流
			while((line=br.readLine())!=null) {
				String[] col=line.split("\t");//拆分为数组
				user.add(new User(col[0],col[1],col[2],col[3]));
				}
		  } catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}
		return user;
		
	}
}
