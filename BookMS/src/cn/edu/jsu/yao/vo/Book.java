package cn.edu.jsu.yao.vo;

import java.io.Serializable;

/**
 * �鱾��,����һ����
 * @author ������
 *
 */
public class Book implements Serializable{
	private String bookName;//����
	private String author;//������
	private String kind;//����
	private String publishName;//������
	private Double price;//�۸�
	private Integer number;//����
	private String time;//����(��������۳�����)
	private String sale="true";//����״̬,Ĭ��Ϊtrue
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName, String author, String kind, String publishName, Double price,
			Integer number, String time, String sale) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.kind = kind;
		this.publishName = publishName;
		this.price = price;
		this.number = number;
		this.time = time;
		this.sale = sale;
	}
	public Book( String bookName, String author, String kind, String publishName, Double price,
			Integer number, String time) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.kind = kind;
		this.publishName = publishName;
		this.price = price;
		this.number = number;
		this.time = time;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + ", kind=" + kind + ", publishName=" + publishName
				+ ", price=" + price + ", number=" + number + ", time=" + time + ", sale=" + sale + "]";
	}
	
	
}
