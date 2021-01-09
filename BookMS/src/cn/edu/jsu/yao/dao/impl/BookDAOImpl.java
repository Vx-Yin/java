package cn.edu.jsu.yao.dao.impl;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import cn.edu.jsu.yao.dao.BookIDAO;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.User;
/**
 * 数据层，书籍操作
 * @author 尹奥琪
 *
 */
public class BookDAOImpl implements BookIDAO{
	private Connection conn;
    public BookDAOImpl(Connection conn) {
		this.conn=conn;
	}
    @Override
	public boolean doCreate(Book book) {
    	if(findBook(book))
    		return false;
		String sql="insert into book(bookName,author,kind,publishName,price,number,time,sale) values(?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement pstmt;
			pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2,book.getAuthor() );
			pstmt.setString(3, book.getKind());
			pstmt.setString(4, book.getPublishName());
			pstmt.setDouble(5, book.getPrice());
			pstmt.setInt(6, book.getNumber());
			pstmt.setString(7,book.getTime());
			pstmt.setString(8, book.getSale());
			int n=pstmt.executeUpdate();
			System.out.println("影响了多少行:"+n);
			if(n==0)
				return false;
		} catch (SQLException e) {
			System.out.println("添加失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}
    @Override
	public boolean doUpdataT(Book book,String time) {
		String sql=	"update  book set  time=? where time=? and bookName=? and sale=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, time);
			pstmt.setString(2, book.getTime());
			pstmt.setString(3, book.getBookName());
			pstmt.setString(4, book.getSale());
			int n=pstmt.executeUpdate();
			System.out.println("影响了多少行:"+n);
			if(n==0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
    @Override
	public boolean doUpdataN(Book book,int number) {
		String sql="update  book set  number=? where time=? and bookName=? and sale=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, book.getTime());
			pstmt.setString(3, book.getBookName());
			pstmt.setString(4, book.getSale());
			int n=pstmt.executeUpdate();
			System.out.println("影响了多少行:"+n);
			if(n==0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean doUpdataS(Book book, String sale) {
		String sql="update  book set  sale=? where time=? and bookName=? and sale=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sale);
			pstmt.setString(2, book.getTime());
			pstmt.setString(3, book.getBookName());
			pstmt.setString(4, book.getSale());
			int n=pstmt.executeUpdate();
			System.out.println("影响了多少行:"+n);
			if(n==0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public boolean doDelete(String name) {
		String sql="delete from book where bookName=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int n=pstmt.executeUpdate();
			System.out.println("影响了多少行:"+n);
			if(n==0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean doDelete(int number) {
		String sql="delete from book where number=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			int n=pstmt.executeUpdate();
			System.out.println("影响了多少行:"+n);
			if(n==0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public Vector<Book> get() {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public Vector<Book> findKind(String kind) {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(4).equals(kind))
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public Vector<Book> findPublish(String PublishName) {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(5).equals(PublishName))
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public Vector<Book> findAuthor(String author) {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(2).equals(author))
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public Boolean findName(String bookName) {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(1).equals(bookName))
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public Vector<Book> findSale(String sale) {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(8).equals(sale))
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public HashSet<String> getKind() {
		HashSet<String> kind=new HashSet<String>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				kind.add(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kind;
	}
	@Override
	public Boolean findBook(Book book) {
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(1).equals(book.getBookName())
						&&rs.getString(7).equals(book.getTime())
						&&rs.getString(8).equals(book.getSale())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public Vector<Book> findBookName(String bookName) {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getString(1).equals(bookName))
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public Vector<Book> findBookPrice(double price) {
		Vector<Book> book=new Vector<Book>();
		String sql="select * from book";
		try (	Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				if(rs.getDouble(5)==price)
					book.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
}
