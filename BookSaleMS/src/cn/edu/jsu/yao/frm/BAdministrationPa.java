package cn.edu.jsu.yao.frm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice.Factory;
import com.mysql.cj.protocol.ServerCapabilities;

import cn.edu.jsu.yao.dao.impl.BookDAOImpl;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
import cn.edu.jsu.yao.vo.Book;
/**
 * 图书管理
 * @author 尹奥琪
 *
 */
public class BAdministrationPa extends JScrollPane{
	IBookService service=ServiceFactory.getBookServiceImpl();//工厂类获取服务
	JScrollPane sp=null;
	JTextField sca=new JTextField();//输入框
	JTable table=new JTable();
	JMenu menuFP=new JMenu("查询出版社");
	JMenu menuFT=new JMenu("查询日期");
	JMenu menuFA=new JMenu("查询作者");
	JMenu menuFPr=new JMenu("查询价格");
	JMenu menuFN=new JMenu("查询书名");
	JMenu menuExit=new JMenu("退出");
	JMenuBar menuBar=new JMenuBar();
	JMenuItem ItemPr=new JMenuItem("查询价格");
	JMenuItem ItemN=new JMenuItem("查询书名");
	JMenuItem ItemP=new JMenuItem("查询出版社");
	JMenuItem ItemT=new JMenuItem("查询日期");
	JMenuItem ItemA=new JMenuItem("查询作者");
	public BAdministrationPa(){
		super();
		setLayout(null);
		Vector<String> title=new Vector<String>();
		Collections.addAll(title, "作者","书名","类别","数目","价格","出版社","销售状态","时间");
		Vector<Vector> bookdata=new Vector<Vector>();//设置名字
		bookdata=service.findBook();
		DefaultTableModel model=new DefaultTableModel(bookdata,title);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//去掉重新设置大小功能
		table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
		sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(90,70,700,500);//滚动面版的大小
		add(sp);
		setBounds(0, 0, 750, 650);//面板的大小
		sca.setBounds(700,40,140,20);
		menuFN.add(ItemN);
		menuFN.add(new JMenuItem("其它"));
		menuFT.add(ItemT);
		menuFT.add(new JMenuItem("其它"));
		menuFPr.add(ItemPr);
		menuFPr.add(new JMenuItem("其它"));
		menuFP.add(ItemP);
		menuFP.add(new JMenuItem("其它"));
		menuFA.add(ItemA);
		menuFA.add(new JMenuItem("其它"));
		menuBar.add(menuFN);
		menuBar.add(menuFPr);
		menuBar.add(menuFT);
		menuBar.add(menuFA);
		menuBar.add(menuFP);
		menuBar.add(menuExit);
		add(menuBar);
		add(sca);
		menuBar.setBounds(0,0,360,20);
		/*
		 * 监听事件
		 */
		//出版社查询
		ItemP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> book=service.findPublish(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
			}
		});
		//作者查询
		ItemA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> book=service.findAuthor(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
			}
		});
		ItemT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findTime(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
			}
		});
		ItemN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findBookName(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
			}
		});
		ItemPr.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double d=Double.parseDouble(sca.getText());
		Vector<Vector> book=service.findBookPrice(d);
		table.setModel(new DefaultTableModel(book,title));
		table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
	}
});
	}
	@Override
    protected void paintComponent(Graphics g1) {// 重写绘制组件外观
		   Graphics2D g = (Graphics2D) g1;
		   g.drawImage(new ImageIcon("data/ImageIcon/p-1.jpg").getImage(), 0, 0,this);
		   g.setFont(new Font("12",Font.BOLD,14));
		   g.drawString("查询:", 650, 55);
			}
}
