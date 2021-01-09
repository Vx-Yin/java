package cn.edu.jsu.yao.service;
import java.util.*;
import cn.edu.jsu.yao.vo.Book;
/**
 * �����鱾��ҵ��������׼
 * @author ������
 *
 */
public interface IBookService {
	/**
	 * ��ѯ�����鼮������Vector��,�����������
	 * @return ���ģ��
	 */
	public Vector<Vector> findBook();
	/**
	 * ��ѯ�����鼮������һ������
	 * @return ���е���
	 */
	public Vector<Book> findAll();
	/**
	 * ����һ����,�Ȼ�ȡ��ǰ����,���������
	 * @param book �鱾
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean buy(Book book);
	/**
	 * ����,����ָ�����������,����µ�����,��״̬�ı䣬��������ԭ�������ݸı��������������Ϊ0,ɾ��ԭ��������
	 * @param book ��
	 * @param number ָ��������
	 * @return true,false
	 */
	public boolean sale(Book book,int number);
	/**
	 * ���������ѯ
	 * @param kind ��ѯ������
	 * @return ��һ���������
	 */
	public Vector<Vector> findKind(String kind);
	/**
	 * ��ѯһ���������������
	 * @param PublishName ��ѯ�ĳ�����
	 * @return �������������
	 */
	public Vector<Vector> findPublish(String PublishName);
	/**
	 * ��ѯһ�����ߵ�������
	 * @param author ��ѯ������
	 * @return ������ߵ�������
	 */
	public Vector<Vector> findAuthor(String author);
	/**
	 * ������������,�Ƿ����
	 * @param bookName ����
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public Boolean findName(String bookName);
	/**
	 * ��ѯָ�����飬���Ƿ����
	 * @param book ��
	 * @return true,false
	 */
	public Boolean findBook(Book book);
	/**
	 * ��ѯָ����ʱ��
	 * @param time ʱ��
	 * @return ����ָ����ͼ��
	 */
	public Vector<Vector> findTime(String time);
	/**
	 * ��ѯ�۳�����δ�۳���ͼ��,saleΪtrueΪ�ڹݣ�Ϊ�۳�
	 * @param sale ����״̬
	 * @return ����ͼ��ļ���
	 */
	public Vector<Vector> findSale(String sale);
	/**
	 * ��ȡ���������������,�������vector
	 * @return ���������������
	 */
	public Vector<String> getKind();
	/**
	 * ����ĿΪ���ͼ���Զ�ɾ��
	 * @return false,true
	 */
	public boolean delete();
	/**
	 * ��ѯָ���۸������ͼ��
	 * @param price �۸�
	 * @return ����ͼ��ļ���
	 */
	public Vector<Vector> findBookPrice(double price);
	/**
	 * ��ѯָ������������ͼ��
	 * @param name ����
	 * @return ����ͼ��ļ���
	 */
	public Vector<Vector> findBookName(String name);
}
