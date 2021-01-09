package cn.edu.jsu.yao.frm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.yao.dao.impl.PublishDAOImpl;
import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
import cn.edu.jsu.yao.service.impl.PublishServiceImpl;

/**
 * 书本的购买界面
 * @author 尹奥琪
 *
 */
public class BuyBookPa extends JPanel{
	public JTextField[] text=new JTextField[6];
	public JComboBox<String> comPublish=null;
	public JComboBox<String> comKind=null;
	public IBookService service=new ServiceFactory().getBookServiceImpl();
	public PublishServiceImpl service2=new PublishServiceImpl();
	public JButton button=new JButton("添加");
	public JButton button2=new JButton("退出");
	public BuyBookPa() {
		setLayout(null);
		for(int i=0;i<6;i++)
			{
			  text[i]=new JTextField();
			  text[i].setBounds(220,125+i*50,200,30);
			  if(!(i==2||i==3))
			  add(text[i]);
			}
		comKind=new JComboBox<String>(service.getKind());
		comPublish=new JComboBox<String>(service2.getPublishName());
		comKind.setBounds(220,225,200,30);
		comPublish.setBounds(220,275,200,30);
		button.setBounds(420,425,100,30);
		button2.setBounds(540,425,100,30);
		button2.setContentAreaFilled(false);
		add(button2);
		button.setContentAreaFilled(false);
		add(button);
		add(comPublish);
		add(comKind);
	
	}
	@Override
	    protected void paintComponent(Graphics g1) {// 重写绘制组件外观
	        Graphics2D g = (Graphics2D) g1;
	        int width = getWidth();// 获取组件大小
	        int height = getHeight();
	        // 创建填充模式对象
	        GradientPaint paint = new GradientPaint(50, 50, Color.CYAN, 0, height,
	                Color.MAGENTA);
	        g.setPaint(paint);// 设置绘图对象的填充模式
	        g.fillRect(0, 0, width, height);// 绘制矩形填充控件界面
	        g.setColor(Color.WHITE);
	    	g.setFont(new Font("16",Font.BOLD,30));
			g.drawString("购买图书", 40,50);
		    g.setColor(Color.white);
			g.setFont(new Font("20",Font.BOLD,20));
			g.drawString("书是人进步的阶梯",170, 80);
			g.setColor(Color.CYAN);
			g.drawString("书名",100, 145);
			g.drawString("作者",100, 195);
			g.drawString("种类",100, 245);
			g.drawString("出版社", 100, 295);
			g.drawString("价格", 100, 345);
			g.drawString("数量", 100, 395);
			g.drawImage(new ImageIcon("data/ImageIcon/icon-2.png").getImage(), 400, 30,this);
	}
	 public static void main(String[] args) {
		JFrame f=new JFrame();
		f.add(new BuyBookPa());
		f.setVisible(true);
	}
}
