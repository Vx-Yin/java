package cn.edu.jsu.yao.service.impl;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.jsu.yao.dao.impl.BookDAOImpl;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.factory.DAOFactory;
import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.vo.Book;
/**
 * 书本有关操作的业务层,实现相关的功能服务
 * @author 尹奥琪
 *
 */
public class BookServiceImpl implements IBookService{
	private DatabaseConnection dbc=null;//建立数据库连接
    public BookServiceImpl() {
		dbc=new DatabaseConnection();
	}
	@Override
	public Vector<Vector> findBook() {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).get();
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			}
		return bookdata;
	}
	@Override
	public Vector<Book> findAll() {
		return DAOFactory.getBookIDAOImpl(dbc.getConnection()).get();
	}

	@Override
	public boolean buy(Book book) {
		// TODO Auto-generated method stub
		String date="yyyy-MM-dd hh:mm";//定义时间模板
		SimpleDateFormat sd=new SimpleDateFormat(date);
		Date td=new Date();//获取当前时间
		String sdata=sd.format(td);
		book.setTime(sdata);
		DAOFactory.getBookIDAOImpl(dbc.getConnection()).doCreate(book);
		return true;
	}

	@Override
	public boolean sale(Book book, int number) {
		String date="yyyy-MM-dd hh:mm";//定义时间模板
		SimpleDateFormat sd=new SimpleDateFormat(date);
		Date td=new Date();//获取当前时间
		String sdata=sd.format(td);
		int n=book.getNumber()-number;
		if(n<0)
			return false;
		DAOFactory.getBookIDAOImpl(dbc.getConnection()).doUpdataN(book, n);//更改数目
		book.setTime(sdata);//更改时间
		book.setNumber(number);//更改数目
		book.setSale("false");
		DAOFactory.getBookIDAOImpl(dbc.getConnection()).doCreate(book);//加入数据，未销售的数据
		return true;
	}

	@Override
	public Vector<Vector> findKind(String kind) {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).get();
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
			if(book.get(i).getKind().equals(kind)) {
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),
					book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			}
			}
		return bookdata;
	}

	@Override
	public Vector<Vector> findPublish(String PublishName) {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).get();
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
			if(book.get(i).getPublishName().equals(PublishName)) {
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),
					book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			}
			}
		return bookdata;
	}

	@Override
	public Vector<Vector> findAuthor(String author) {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).get();
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
			if(book.get(i).getAuthor().equals(author)) {
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),
					book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			}
			}
		return bookdata;
	}

	@Override
	public Boolean findName(String bookName) {
		return DAOFactory.getBookIDAOImpl(dbc.getConnection()).findName(bookName);
	}
	@Override
	public Vector<Vector> findTime(String time) {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).get();
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
			if(book.get(i).getTime().startsWith(time)) {
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),
					book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			}
			}
		return bookdata;
	}
	@Override
	public Vector<Vector> findSale(String sale) {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).findSale(sale);
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
		
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),
					book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			
			}
		return bookdata;
	}
	@Override
	public Vector<String> getKind() {
		HashSet<String> kind=DAOFactory.getBookIDAOImpl(dbc.getConnection()).getKind();
		Vector<String> data=new Vector<String>();
		Iterator<String> it = kind.iterator();
		while(it.hasNext()) {
			data.add(it.next());
		}
		return data;
	}
	@Override
	public Boolean findBook(Book book) {
		return DAOFactory.getBookIDAOImpl(dbc.getConnection()).findBook(book);
	}
	@Override
	public boolean delete() {
		return DAOFactory.getBookIDAOImpl(dbc.getConnection()).doDelete(0);
	}
	@Override
	public Vector<Vector> findBookPrice(double price) {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).findBookPrice(price);
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
		
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),
					book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			
			}
		return bookdata;
	}
	@Override
	public Vector<Vector> findBookName(String name) {
		Vector<Book> book=DAOFactory.getBookIDAOImpl(dbc.getConnection()).findBookName(name);
		Vector<Vector> bookdata=new Vector<Vector>();
		for(int i=0;i<book.size();i++)
			{
		
			Vector row=new Vector<>();
			Collections.addAll(row,book.get(i).getAuthor(),
					book.get(i).getBookName(),book.get(i).getKind(),book.get(i).getNumber()
					,book.get(i).getPrice(),book.get(i).getPublishName(),book.get(i).getSale(),book.get(i).getTime());
			bookdata.add(row);
			
			}
		return bookdata;
	}
}
