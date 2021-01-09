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
 * 用户注册界面
 * @author 尹奥琪
 *
 */
class RShade extends JPanel {
	IUserService service=new ServiceFactory().getUserServiceImpl();
	JTextField fieldUsername=new JTextField();
	JTextField fieldAcount=new JTextField();
	JTextField fieldPassword=new JTextField();
	JButton button=new JButton("注册");
	JButton button2=new JButton("退出");
	JComboBox jc=null;
    public RShade() {
        super();
        Vector<String> check=new Vector<String>();
        check.add("男");
        check.add("女");
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
				//注册界面，输入不能为空，不能注册相同的用户
				if(fieldUsername.getText().equals("")||fieldAcount.getText().equals("")||fieldPassword.getText().equals(""))
					JOptionPane.showMessageDialog(null, "输入不能为空", "提示",JOptionPane.WARNING_MESSAGE);
				else {
					if(service.find(fieldAcount.getText()))
						JOptionPane.showMessageDialog(null, "已有该用户", "提示",JOptionPane.WARNING_MESSAGE);
					else
				{
				if(jc.getItemAt(jc.getSelectedIndex()).equals("男"))
					service.register(new User(fieldUsername.getText(),fieldAcount.getText(),fieldPassword.getText(),"男"));
				else
					service.register(new User(fieldUsername.getText(),fieldAcount.getText(),fieldPassword.getText(),"女"));
				JOptionPane.showMessageDialog(null, "注册成功", "提示",JOptionPane.WARNING_MESSAGE);
				fieldAcount.setText("");
				fieldUsername.setText("");
				fieldPassword.setText("");
				}
				}
				}
		});
       
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
		g.drawString("欢迎注册", 40,50);
	    g.setColor(Color.white);
		g.setFont(new Font("20",Font.BOLD,20));
		g.drawString("书是人进步的阶梯",170, 80);
		g.setColor(Color.CYAN);
		g.drawString("用户名",100, 145);
		g.drawString("账号",100, 195);
		g.drawString("密码",100, 245);
		g.drawString("身份", 100, 295);;
		g.drawImage(new ImageIcon("data/ImageIcon/icon-2.png").getImage(), 400, 30,this);
    }
}