package cn.edu.jsu.yao.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import cn.edu.jsu.yao.dao.impl.UserDAOImpl;
import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.User;
/**
 * ���ݲ�β�����׼,�鱾�Ĳ���
 * @author ������
 *
 */
public interface BookIDAO extends IDAO<Book>{
	@Override
	/**
	 * ����һ���鱾,����Ҫ�ж��鱾�Ƿ���ڣ������б�ѡ�������
	 * @param book �鱾
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean doCreate(Book book);
	/**
	 * �����鱾��ʱ��
	 * @param book ��
	 * @param time ʱ��
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean doUpdataT(Book book,String time);
	/**
	 * �����������״̬
	 * @param book ����
	 * @param sale ����״̬
	 * @return true,false
	 */
	public boolean doUpdataS(Book book,String sale);
	/**
	 * �����鱾������
	 * @param book ��
	 * @param number Ҫ���ĵ�����
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean doUpdataN(Book book,int number);
	/**
	 * ����ָ��������ɾ��ͼ��
	 * @param name ����
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean doDelete(String name);
	/**
	 * ��ѯ���е�����
	 * @return �������е�����
	 */
	@Override
	public Vector<Book> get();
	/**
	 * ���������ѯ
	 * @param kind ��ѯ������
	 * @return ��һ���������
	 */
	public Vector<Book> findKind(String kind);
	/**
	 * ��ѯһ���������������
	 * @param PublishName ��ѯ�ĳ�����
	 * @return �������������
	 */
	public Vector<Book> findPublish(String PublishName);
	/**
	 * ��ѯָ����������������
	 * @param bookName ����
	 * @return һ������
	 */
	public Vector<Book> findBookName(String bookName);
	/**
	 * ��ѯָ���۸��������
	 * @param price �۸�
	 * @return һ������
	 */
	public Vector<Book> findBookPrice(double price);
	/**
	 * ��ѯһ�����ߵ�������
	 * @param author ��ѯ������
	 * @return ������ߵ�������
	 */
	public Vector<Book> findAuthor(String author);
	/**
	 * ��ѯָ������״̬���鼮
	 * @param sale ����״̬
	 * @return ����
	 */
	public Vector<Book> findSale(String sale);
	/**
	 * ������������,�Ƿ����
	 * @param bookName ����
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public Boolean findName(String bookName);
	/**
	 * ����ָ��״̬���飬����ʱ�䣬����״̬��ʱ��
	 * @param book ��
	 * @return true,false
	 */
	public Boolean findBook(Book book);
	/**
	 * ��ȡ�����������,�����ظ�������HashSet����
	 * @return ��������������
	 */
	public HashSet<String> getKind();
	/**
	 * ��ָ����Ŀɾ��
	 * @param number ����
	 * @return false��true
	 */
	public boolean doDelete(int number);
}
