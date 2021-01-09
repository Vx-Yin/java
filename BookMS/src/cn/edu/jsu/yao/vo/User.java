package cn.edu.jsu.yao.vo;
import java.io.Serializable;
import javax.swing.ImageIcon;
/**
 * 用户的账号，用来登录系统
 * @author 尹奥琪
 *
 */
public class User implements Serializable{
	private String username;//用户名
	private String account;//账号
	private String password;//密码
	private String sex;//是否为管理员，默认为false
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String account, String password, String sex) {
		super();
		this.username = username;
		this.account = account;
		this.password = password;
		this.sex =sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", account=" + account + ", password=" + password + ", sex=" + sex + "]";
	}

	
}
