package cn.edu.jsu.yao.frm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import cn.edu.jsu.yao.service.impl.BookServiceImpl;
/**
 * ������
 * @author ������
 *
 */
public class BookRoot extends JFrame{
	JTabbedPane tp=new JTabbedPane(JTabbedPane.TOP);//�����л�
	BAdministrationPa panel1=new BAdministrationPa();
	BSalePa panel2=new BSalePa();
	BKindPa panel3=new BKindPa();
	PublishRShade panel4=new PublishRShade();
	public BookRoot() {
		tp.add("ͼ�����",panel1);
		tp.add("ͼ������",panel2);
		tp.add("�������",panel3);
		tp.add("�������",panel4);
		tp.add("��������Ϣ�Ǽ�",panel4);
		add(tp);
		setBounds(20,20, 1000, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BookRoot();
	}
}
