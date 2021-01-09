package cn.edu.jsu.yao.frm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IUserService;
import cn.edu.jsu.yao.service.impl.UserServiceImpl;
import cn.edu.jsu.yao.vo.User;
/**
 * �û�ע�����
 * @author ������
 *
 */
class RShade extends JPanel {
	IUserService service=new ServiceFactory().getUserServiceImpl();
	JTextField fieldUsername=new JTextField();
	JTextField fieldAcount=new JTextField();
	JTextField fieldPassword=new JTextField();
	JButton button=new JButton("ע��");
	JButton button2=new JButton("�˳�");
	JComboBox jc=null;
    public RShade() {
        super();
        Vector<String> check=new Vector<String>();
        check.add("��");
        check.add("Ů");
        jc=new JComboBox(check);
        setLayout(null);
        fieldUsername.setBounds(220,120,200,30);
        fieldAcount.setBounds(220,170,200,30);
        fieldPassword.setBounds(220,220,200,30);
        button.setBounds(200,320,100,30);
        button2.setBounds(460, 350, 70, 20);
        button.setContentAreaFilled(false);
        jc.setBounds(220,270,200,30);
        button2.setContentAreaFilled(false);
        add(button2);
        add(button);
        add(jc);
        add(fieldAcount);
        add(fieldPassword);
        add(fieldUsername);
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ע����棬���벻��Ϊ�գ�����ע����ͬ���û�
				if(fieldUsername.getText().equals("")||fieldAcount.getText().equals("")||fieldPassword.getText().equals(""))
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��ʾ",JOptionPane.WARNING_MESSAGE);
				else {
					if(service.find(fieldAcount.getText()))
						JOptionPane.showMessageDialog(null, "���и��û�", "��ʾ",JOptionPane.WARNING_MESSAGE);
					else
				{
				if(jc.getItemAt(jc.getSelectedIndex()).equals("��"))
					service.register(new User(fieldUsername.getText(),fieldAcount.getText(),fieldPassword.getText(),"��"));
				else
					service.register(new User(fieldUsername.getText(),fieldAcount.getText(),fieldPassword.getText(),"Ů"));
				JOptionPane.showMessageDialog(null, "ע��ɹ�", "��ʾ",JOptionPane.WARNING_MESSAGE);
				fieldAcount.setText("");
				fieldUsername.setText("");
				fieldPassword.setText("");
				}
				}
				}
		});
       
    }   
    @Override
    protected void paintComponent(Graphics g1) {// ��д����������
        Graphics2D g = (Graphics2D) g1;
        int width = getWidth();// ��ȡ�����С
        int height = getHeight();
        // �������ģʽ����
        GradientPaint paint = new GradientPaint(50, 50, Color.CYAN, 0, height,
                Color.MAGENTA);
        g.setPaint(paint);// ���û�ͼ��������ģʽ
        g.fillRect(0, 0, width, height);// ���ƾ������ؼ�����
        g.setColor(Color.WHITE);
    	g.setFont(new Font("16",Font.BOLD,30));
		g.drawString("��ӭע��", 40,50);
	    g.setColor(Color.white);
		g.setFont(new Font("20",Font.BOLD,20));
		g.drawString("�����˽����Ľ���",170, 80);
		g.setColor(Color.CYAN);
		g.drawString("�û���",100, 145);
		g.drawString("�˺�",100, 195);
		g.drawString("����",100, 245);
		g.drawString("���", 100, 295);;
		g.drawImage(new ImageIcon("data/ImageIcon/icon-2.png").getImage(), 400, 30,this);
    }
}