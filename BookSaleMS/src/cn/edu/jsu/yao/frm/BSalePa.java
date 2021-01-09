package cn.edu.jsu.yao.frm;

import java.awt.Font;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.yao.Run.BuyBookFrRun;
import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
import cn.edu.jsu.yao.vo.Book;
/**
 * 销售管理
 * @author 尹奥琪
 *
 */
public class BSalePa extends JPanel{
	public JButton button=new JButton("销售");
	public JButton button2=new JButton("进书");
	public JButton button3=new JButton("刷新");
	public JTextField text=new JTextField();
	public IBookService service=ServiceFactory.getBookServiceImpl();//工厂类获取服务
	JScrollPane sp=null;
	JTable table=new JTable();
	JMenu menuS=new JMenu("已售出图书");
	JMenu menuUS=new JMenu("在售出图书");
	JMenu menuExit=new JMenu("退出");
	JMenuBar menuBar=new JMenuBar();
	JMenuItem ItemS=new JMenuItem("已售出图书");
	JMenuItem Item=new JMenuItem("其它");
	JMenuItem Item2=new JMenuItem("其它");
	JMenuItem ItemUS=new JMenuItem("在售出图书");
	DefaultTableModel model=null;//表格数据
	public BSalePa() {
		super();
		setLayout(null);
		Vector<String> title=new Vector<String>();
		Collections.addAll(title, "作者","书名","类别","数目","价格","出版社","销售状态","时间");
		Vector<Vector> bookdata=new Vector<Vector>();//设置名字
		bookdata=service.findBook();
		model=new DefaultTableModel(bookdata,title);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//去掉重新设置大小功能
		table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
		sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(90,70,700,500);//滚动面版的大小
		button.setBounds(600,30,100,25);
		button.setContentAreaFilled(false);
		button2.setBounds(470,30,100,25);
		button2.setContentAreaFilled(false);
		button3.setBounds(340,30,100,25);
		button3.setContentAreaFilled(false);
		text.setBounds(720,30,100,25);
		setBounds(0, 0, 750, 650);//面板的大小
		menuBar.add(menuS);
		menuBar.add(menuUS);
		menuS.add(ItemS);
		menuS.add(Item);
		menuUS.add(ItemUS);
		menuUS.add(Item2);
		menuBar.add(menuExit);
		add(button);
		add(button2);
		add(button3);
		add(text);
		add(sp);
//      setLayout(null);
//      tp.setBounds(100,100,400,400);
		add(menuBar);
		menuBar.setBounds(0,0,190,20);
		/*
		 * 监听事件
		 */
		//出版社查询
		ItemUS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findSale("true");
				model=new DefaultTableModel(book,title);
				table.setModel(model);
				table.getColumnModel().getColumn(7).setPreferredWidth(200);
			}
		});
		ItemS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findSale("false");
				model=new DefaultTableModel(book,title);
				table.setModel(model);
				table.getColumnModel().getColumn(7).setPreferredWidth(200);
			}
		});
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if(row==-1)
					JOptionPane.showMessageDialog(null, "未选择任何一列", "警告",JOptionPane.WARNING_MESSAGE);
				else
				{
				Book b=new Book();
				Vector data=getSelect(row);
				if(data==null)
					JOptionPane.showMessageDialog(null, "未选择销售的图书", "警告",JOptionPane.WARNING_MESSAGE);
				else {
					b.setAuthor((String)data.get(0));
					b.setBookName((String)data.get(1));
					b.setKind((String)data.get(2));
					b.setNumber((int)data.get(3));
					b.setPrice((double)data.get(4));
					b.setPublishName((String)data.get(5));
					b.setSale((String) data.get(6));
					b.setTime((String)data.get(7));
					String td=text.getText();
					if(!isNumeric(td))
						JOptionPane.showMessageDialog(null, "输入必须为整数", "警告",JOptionPane.WARNING_MESSAGE);
					else if(td.length()>5) {
						JOptionPane.showMessageDialog(null, "数目过大", "警告",JOptionPane.WARNING_MESSAGE);
					}
					else if(td.length()==0)
						JOptionPane.showMessageDialog(null, "输入不能为空", "警告",JOptionPane.WARNING_MESSAGE);
					else{
					int number=Integer.valueOf(td);
					if(service.sale(b, number))
						{
						 JOptionPane.showMessageDialog(null, "销售成功", "提示",JOptionPane.WARNING_MESSAGE);
						 model=new DefaultTableModel( service.findBook(),title);
						 table.setModel(model);
						}
					else
						JOptionPane.showMessageDialog(null, "销售失败", "提示",JOptionPane.WARNING_MESSAGE);
					table.getColumnModel().getColumn(7).setPreferredWidth(200);
				}
				}
			}
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t=new Thread(new BuyBookFrRun());
				t.start();
			}
		});
		button3.addActionListener(new ActionListener() {
			//重新读取数据，刷新，数目为零的图书自动删除
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> book=service.findBook();
				service.delete();
				model=new DefaultTableModel(book,title);
				table.setModel(model);
				table.getColumnModel().getColumn(7).setPreferredWidth(200);
			}
		});
	}
	public Vector getSelect(int row) {
		Vector book=new Vector<Vector>();
		if(table.getValueAt(row, 6).equals("false"))
			return null;
		for(int i=0;i<8;i++)
			  book.add(table.getValueAt(row, i));
			
		return book;
	}
	public static boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
				}
			}return true;}
	@Override
    protected void paintComponent(Graphics g1) {// 重写绘制组件外观
		   Graphics2D g = (Graphics2D) g1;
		   g.drawImage(new ImageIcon("data/ImageIcon/p-1.jpg").getImage(), 0, 0,this);
			}
}
