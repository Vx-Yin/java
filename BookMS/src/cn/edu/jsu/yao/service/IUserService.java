package cn.edu.jsu.yao.service;
import java.util.Vector;
import cn.edu.jsu.yao.vo.User;
/**
 * �����û���ҵ��������׼
 * @author ������
 *
 */
public interface IUserService {
	/**
	 * ��ѯָ���û�������
	 * @param account �˺�
	 * @return	�ɹ�����true,ʧ�ܷ���false
	 */
	public boolean find(String account);
    /**
     * �û�ע��,��Ҫ�����Ƿ��ظ�
     * @param user �û�
     * @return true,false
     */
	public boolean register(User user);
    /**
     * ����û�������������ȷ���1,�������ֻ���û�����ȷ���0,�û������ڷ���-1
     * @param account �û�
     * @param password ����
     * @return 0��1��-1
     */
	public int logon(String account,String password);
	/**
	 * �����Ȳ�ѯ�Ƿ����,�޸�ָ���û�������
	 * @param user �û�
	 * @param passage ����
	 * @return true,false
	 */
	public boolean UpdataPassage(User user,String passage) ;
	/**
	 * ��ȡ���е�����
	 * @return �û��ļ���
	 */
	public Vector<User> get();
		
}
