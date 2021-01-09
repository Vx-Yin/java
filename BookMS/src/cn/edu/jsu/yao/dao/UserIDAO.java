package cn.edu.jsu.yao.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.User;
/**
 * 数据层定义用户操作的数据操作标准
 * @author 尹奥琪
 *
 */
public interface UserIDAO extends IDAO<User>{
	@Override
	/**
	 * 用户增加操作，需判断是否存在
	 * @param user 需要增加的用户
	 * @return 成功返回true，失败false
	 */
	public boolean doCreate(User user);
	@Override
	/**
	 * 得到用户的所有数据
	 * @return 返回用户的集合
	 */
	public Vector<User> get();
	/**
	 * 将指定的用户的密码更改为指定的password
	 * @param account 指定的用户
	 * @param password 指定的用户名
	 * @return 成功返回true,失败返回false
	 */
	public boolean doUpdata(String account,String password);
	/**
	 * 按照指定的账号和密码查找，只有账号一致返回0，都符合返回1，否则返沪-1
	 * @param account 账号
	 * @param password 密码
	 * @return 0，1，-1
	 */
	public int find(String account,String password);
	/**
	 * 查询指定账号是否存在，成功返回true,失败返回false
	 * @param account 账号
	 * @return true,false
	 */
	public Boolean find(String account);
}
