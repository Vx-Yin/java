package cn.edu.jsu.yao.frm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import cn.edu.jsu.yao.service.impl.BookServiceImpl;
/**
 * 主界面
 * @author 尹奥琪
 *
 */
public class BookRoot extends JFrame{
	JTabbedPane tp=new JTabbedPane(JTabbedPane.TOP);//界面切换
	BAdministrationPa panel1=new BAdministrationPa();
	BSalePa panel2=new BSalePa();
	BKindPa panel3=new BKindPa();
	PublishRShade panel4=new PublishRShade();
	public BookRoot() {
		tp.add("图书管理",panel1);
		tp.add("图书销售",panel2);
		tp.add("分类管理",panel3);
		tp.add("分类管理",panel4);
		tp.add("出版社信息登记",panel4);
		add(tp);
		setBounds(20,20, 1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BookRoot();
	}
}
