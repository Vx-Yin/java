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
 * ��¼����,��ʾ�û�����������û���
 * @author ������
 *
 */
public class JLogon extends JFrame {
	IUserService service=new ServiceFactory().getUserServiceImpl();
	LShade panel=new LShade();//����
	Icon iconHead=new ImageIcon("data/ImageIcon/headP.png");//ͷ��
	JLabel labelIcon=new JLabel(iconHead);//��ǩ
	JButton buttonRegister=new JButton("ע��");//��¼��ť
	JButton buttonIogon=new JButton("��¼");//ע�ᰴť
	JTextField textUser=new JTextField();//�û��������
	JPasswordField textPassword=new JPasswordField();//���������
	JLabel labelUser=new JLabel("�û���:");
	JLabel labelPassword=new JLabel("����:");
	JLabel labelUserTip=new JLabel("");
	JLabel labelPasswordTip=new JLabel("");
	/**
	 * ���캯��
	 */
    public JLogon() {
       setTitle("ͼ�����ϵͳ");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر��˳�
	   setLayout(null);//���ÿղ���
	   getContentPane().setBackground(Color.white);
	   //�������
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
	   //���ô�С
	   buttonRegister.addActionListener(
		   //ע��
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
			// ��¼,���������û����Ƿ�������ȷ����������ʾ��Ϣ
			int n=service.logon(textUser.getText(),textPassword.getText());
			 if(n==1)
			 {	
				new BookRoot();
				dispose();
			 }
			  else if(n==0) {
				  labelPasswordTip.setForeground(Color.red);
				  textPassword.selectAll();
				  labelPasswordTip.setText("�������");
			  }
			  else {
				  labelUserTip.setForeground(Color.red);
				  textUser.selectAll();
				  labelUserTip.setText("�û���������");
			  }
				  
		}
	});
	   textPassword.addFocusListener(new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {
		}
		@Override
		public void focusGained(FocusEvent e) {
			// ���û�׼����������,��ʾ��ʧ
			labelPasswordTip.setText("");
		}
	});
	   textUser.addFocusListener(new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {
			
		}
		@Override
		public void focusGained(FocusEvent e) {
			//���û�׼�������û�������ʾ��ʧ
			labelUserTip.setText("");
		}
	});
	   //�¼�����
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
	   setResizable(false);//���ɵ�����С
	   setVisible(true);
	   //������
   }
}