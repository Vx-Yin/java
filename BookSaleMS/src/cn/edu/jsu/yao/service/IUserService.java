package cn.edu.jsu.yao.service;
import java.util.Vector;
import cn.edu.jsu.yao.vo.User;
/**
 * 定义用户在业务的需求标准
 * @author 尹奥琪
 *
 */
public interface IUserService {
	/**
	 * 查询指定用户的数据
	 * @param account 账号
	 * @return	成功返回true,失败返回false
	 */
	public boolean find(String account);
    /**
     * 用户注册,需要考虑是否重复
     * @param user 用户
     * @return true,false
     */
	public boolean register(User user);
    /**
     * 如果用户存在且密码相等返回1,否则如果只有用户名相等返回0,用户不存在返回-1
     * @param account 用户
     * @param password 密码
     * @return 0，1，-1
     */
	public int logon(String account,String password);
	/**
	 * 首先先查询是否存在,修改指定用户的密码
	 * @param user 用户
	 * @param passage 密码
	 * @return true,false
	 */
	public boolean UpdataPassage(User user,String passage) ;
	/**
	 * 获取所有的数据
	 * @return 用户的集合
	 */
	public Vector<User> get();
		
}
