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
 * 数据层次操作标准,书本的操作
 * @author 尹奥琪
 *
 */
public interface BookIDAO extends IDAO<Book>{
	@Override
	/**
	 * 创建一个书本,首先要判断书本是否存在，下拉列表选择出版社
	 * @param book 书本
	 * @return 成功返回true,失败返回false
	 */
	public boolean doCreate(Book book);
	/**
	 * 更改书本的时间
	 * @param book 书
	 * @param time 时间
	 * @return 成功返回true,失败返回false
	 */
	public boolean doUpdataT(Book book,String time);
	/**
	 * 更改书的销售状态
	 * @param book 书名
	 * @param sale 销售状态
	 * @return true,false
	 */
	public boolean doUpdataS(Book book,String sale);
	/**
	 * 更改书本的数量
	 * @param book 书
	 * @param number 要更改的数量
	 * @return 成功返回true,失败返回false
	 */
	public boolean doUpdataN(Book book,int number);
	/**
	 * 按照指定的书名删除图书
	 * @param name 书名
	 * @return 成功返回true,失败返回false
	 */
	public boolean doDelete(String name);
	/**
	 * 查询所有的数据
	 * @return 返回所有的数据
	 */
	@Override
	public Vector<Book> get();
	/**
	 * 按照种类查询
	 * @param kind 查询的种类
	 * @return 这一个种类的书
	 */
	public Vector<Book> findKind(String kind);
	/**
	 * 查询一个出版社的所有书
	 * @param PublishName 查询的出版社
	 * @return 出版社的所有书
	 */
	public Vector<Book> findPublish(String PublishName);
	/**
	 * 查询指定书名的所有数据
	 * @param bookName 书名
	 * @return 一个集合
	 */
	public Vector<Book> findBookName(String bookName);
	/**
	 * 查询指定价格的所有书
	 * @param price 价格
	 * @return 一个集合
	 */
	public Vector<Book> findBookPrice(double price);
	/**
	 * 查询一个作者的所有书
	 * @param author 查询的作者
	 * @return 这个作者的所有书
	 */
	public Vector<Book> findAuthor(String author);
	/**
	 * 查询指定销售状态的书籍
	 * @param sale 销售状态
	 * @return 集合
	 */
	public Vector<Book> findSale(String sale);
	/**
	 * 按照书名查找,是否存在
	 * @param bookName 书名
	 * @return 成功返回true,失败返回false
	 */
	public Boolean findName(String bookName);
	/**
	 * 查找指定状态的书，包括时间，销售状态，时间
	 * @param book 书
	 * @return true,false
	 */
	public Boolean findBook(Book book);
	/**
	 * 获取所有书的种类,不能重复，返回HashSet类型
	 * @return 所有书类别的名字
	 */
	public HashSet<String> getKind();
	/**
	 * 按指定数目删除
	 * @param number 数量
	 * @return false，true
	 */
	public boolean doDelete(int number);
}
