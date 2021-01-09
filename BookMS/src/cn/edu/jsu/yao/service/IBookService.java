package cn.edu.jsu.yao.service;
import java.util.*;
import cn.edu.jsu.yao.vo.Book;
/**
 * 定义书本在业务的需求标准
 * @author 尹奥琪
 *
 */
public interface IBookService {
	/**
	 * 查询所有书籍，返回Vector类,用来创建表格
	 * @return 表格模型
	 */
	public Vector<Vector> findBook();
	/**
	 * 查询所有书籍，返回一个数组
	 * @return 所有的书
	 */
	public Vector<Book> findAll();
	/**
	 * 买入一本书,先获取当前日期,再添加数据
	 * @param book 书本
	 * @return 成功返回true,失败返回false
	 */
	public boolean buy(Book book);
	/**
	 * 卖书,可以指定卖书的数量,添加新的数据,将状态改变，数量。将原来的数据改变数量，如果数量为0,删除原来的数据
	 * @param book 书
	 * @param number 指定的数量
	 * @return true,false
	 */
	public boolean sale(Book book,int number);
	/**
	 * 按照种类查询
	 * @param kind 查询的种类
	 * @return 这一个种类的书
	 */
	public Vector<Vector> findKind(String kind);
	/**
	 * 查询一个出版社的所有书
	 * @param PublishName 查询的出版社
	 * @return 出版社的所有书
	 */
	public Vector<Vector> findPublish(String PublishName);
	/**
	 * 查询一个作者的所有书
	 * @param author 查询的作者
	 * @return 这个作者的所有书
	 */
	public Vector<Vector> findAuthor(String author);
	/**
	 * 按照书名查找,是否存在
	 * @param bookName 书名
	 * @return 成功返回true,失败返回false
	 */
	public Boolean findName(String bookName);
	/**
	 * 查询指定的书，看是否存在
	 * @param book 书
	 * @return true,false
	 */
	public Boolean findBook(Book book);
	/**
	 * 查询指定的时间
	 * @param time 时间
	 * @return 返回指定的图书
	 */
	public Vector<Vector> findTime(String time);
	/**
	 * 查询售出或者未售出的图书,sale为true为在馆，为售出
	 * @param sale 销售状态
	 * @return 返回图书的集合
	 */
	public Vector<Vector> findSale(String sale);
	/**
	 * 获取书店的所有书的种类,将其放入vector
	 * @return 所有书种类的名称
	 */
	public Vector<String> getKind();
	/**
	 * 将数目为零的图书自动删除
	 * @return false,true
	 */
	public boolean delete();
	/**
	 * 查询指定价格的所有图书
	 * @param price 价格
	 * @return 返回图书的集合
	 */
	public Vector<Vector> findBookPrice(double price);
	/**
	 * 查询指定书名的所有图书
	 * @param name 姓名
	 * @return 返回图书的集合
	 */
	public Vector<Vector> findBookName(String name);
}
