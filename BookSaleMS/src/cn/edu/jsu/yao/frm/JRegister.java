package cn.edu.jsu.yao.frm;
import javax.swing.*;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.poi.sl.draw.Drawable;

import cn.edu.jsu.yao.service.impl.UserServiceImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
/**
 * �û�ע�����
 * @author ������
 *
 */
public class JRegister extends JFrame{
		RShade panel=new RShade();//ע�����
		public JRegister() {
			add(panel);
			setBounds(300,150,550,410);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			panel.button2.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent e) {
						// �����л�
						dispose();
						new JLogon();
					}
				});
	   }	
	}

