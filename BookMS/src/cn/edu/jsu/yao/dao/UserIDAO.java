package cn.edu.jsu.yao.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.User;
/**
 * ���ݲ㶨���û����������ݲ�����׼
 * @author ������
 *
 */
public interface UserIDAO extends IDAO<User>{
	@Override
	/**
	 * �û����Ӳ��������ж��Ƿ����
	 * @param user ��Ҫ���ӵ��û�
	 * @return �ɹ�����true��ʧ��false
	 */
	public boolean doCreate(User user);
	@Override
	/**
	 * �õ��û�����������
	 * @return �����û��ļ���
	 */
	public Vector<User> get();
	/**
	 * ��ָ�����û����������Ϊָ����password
	 * @param account ָ�����û�
	 * @param password ָ�����û���
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean doUpdata(String account,String password);
	/**
	 * ����ָ�����˺ź�������ң�ֻ���˺�һ�·���0�������Ϸ���1�����򷵻�-1
	 * @param account �˺�
	 * @param password ����
	 * @return 0��1��-1
	 */
	public int find(String account,String password);
	/**
	 * ��ѯָ���˺��Ƿ���ڣ��ɹ�����true,ʧ�ܷ���false
	 * @param account �˺�
	 * @return true,false
	 */
	public Boolean find(String account);
}
