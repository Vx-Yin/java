package cn.edu.jsu.yao.vo;
import java.io.Serializable;
import javax.swing.ImageIcon;
/**
 * �û����˺ţ�������¼ϵͳ
 * @author ������
 *
 */
public class User implements Serializable{
	private String username;//�û���
	private String account;//�˺�
	private String password;//����
	private String sex;//�Ƿ�Ϊ����Ա��Ĭ��Ϊfalse
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
