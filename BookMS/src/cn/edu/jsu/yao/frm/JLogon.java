package cn.edu.jsu.yao.frm;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;

import cn.edu.jsu.yao.Run.LogonRun;
import cn.edu.jsu.yao.Run.RegisterRun;
import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IUserService;
import cn.edu.jsu.yao.service.impl.UserServiceImpl;
import cn.edu.jsu.yao.vo.User;
/**
 * 登录界面,提示用户输入密码和用户名
 * @author 尹奥琪
 *
 */
public class JLogon extends JFrame {
	IUserService service=new ServiceFactory().getUserServiceImpl();
	LShade panel=new LShade();//背景
	Icon iconHead=new ImageIcon("data/ImageIcon/headP.png");//头像
	JLabel labelIcon=new JLabel(iconHead);//标签
	JButton buttonRegister=new JButton("注册");//登录按钮
	JButton buttonIogon=new JButton("登录");//注册按钮
	JTextField textUser=new JTextField();//用户名输入框
	JPasswordField textPassword=new JPasswordField();//密码输入框
	JLabel labelUser=new JLabel("用户名:");
	JLabel labelPassword=new JLabel("密码:");
	JLabel labelUserTip=new JLabel("");
	JLabel labelPasswordTip=new JLabel("");
	/**
	 * 构造函数
	 */
    public JLogon() {
       setTitle("图书管理系统");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭退出
	   setLayout(null);//设置空布局
	   getContentPane().setBackground(Color.white);
	   //设置组件
	   panel.setBounds(0, 0, 550, 175);
	   labelIcon.setBounds(35, 195, 90, 90);
	   labelUser.setBounds(150, 205, 50, 20);
	   labelPassword.setBounds(150, 255, 50, 20);
	   labelUserTip.setBounds(420, 205, 100, 20);
	   labelPasswordTip.setBounds(420, 255, 100, 20);
       textUser.setBounds(235,205,175,25);
       textPassword.setBounds(235,255,175,25);
       buttonIogon.setBounds(110,305,150,30);
       buttonRegister.setBounds(290,305,150,30);
	   setBounds(300,150,550,380);
	   //设置大小
	   buttonRegister.addActionListener(
		   //注册
		   new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e) {
			  new Thread(new RegisterRun()).start();
			  dispose();
		   }
		   }
		);
	   buttonIogon.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 登录,检查密码和用户名是否输入正确，并给出提示信息
			int n=service.logon(textUser.getText(),textPassword.getText());
			 if(n==1)
			 {	
				new BookRoot();
				dispose();
			 }
			  else if(n==0) {
				  labelPasswordTip.setForeground(Color.red);
				  textPassword.selectAll();
				  labelPasswordTip.setText("密码错误");
			  }
			  else {
				  labelUserTip.setForeground(Color.red);
				  textUser.selectAll();
				  labelUserTip.setText("用户名不存在");
			  }
				  
		}
	});
	   textPassword.addFocusListener(new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {
		}
		@Override
		public void focusGained(FocusEvent e) {
			// 当用户准备输入密码,提示消失
			labelPasswordTip.setText("");
		}
	});
	   textUser.addFocusListener(new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {
			
		}
		@Override
		public void focusGained(FocusEvent e) {
			//当用户准备输入用户名，提示消失
			labelUserTip.setText("");
		}
	});
	   //事件处理
	   add(panel);
	   add(labelIcon);
	   add(labelUser);
	   add(labelPassword);
	   add(textPassword);
	   add(textUser);
	   add(buttonRegister);
	   add(buttonIogon);
	   add(labelUserTip);
	   add(labelPasswordTip);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setResizable(false);//不可调整大小
	   setVisible(true);
	   //添加组件
   }
}