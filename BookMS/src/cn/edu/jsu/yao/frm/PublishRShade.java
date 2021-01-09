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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IPublishService;
import cn.edu.jsu.yao.service.IUserService;
import cn.edu.jsu.yao.service.impl.PublishServiceImpl;
import cn.edu.jsu.yao.service.impl.UserServiceImpl;
import cn.edu.jsu.yao.vo.Publish;
import cn.edu.jsu.yao.vo.User;

/**
 * 出版社注册的面板,界面
 * @author 尹奥琪
 *
 */
public class PublishRShade extends JPanel{
	IUserService serviceUser=new ServiceFactory().getUserServiceImpl();
	IPublishService servicePublish=new  ServiceFactory().getPublishServiceImpl();
	JTextField fieldID=new JTextField();
	JTextField fieldName=new JTextField();
	JTextField fieldUser=new JTextField();
	JButton button=new JButton("注册");
	JComboBox<String> jc=null;
    public PublishRShade() {
        super();
        Vector<String> check=new Vector<String>();
        check.add("男");
        check.add("女");
        jc=new JComboBox<String>(check);
        setLayout(null);
        fieldID.setBounds(220,120,200,30);
        fieldName.setBounds(220,170,200,30);
        fieldUser.setBounds(220,220,200,30);
        button.setBounds(200,320,100,30);
        button.setContentAreaFilled(false);
        jc.setBounds(220,270,200,30);
        add(button);
        add(jc);
        add(fieldName);
        add(fieldUser);
        add(fieldID);
        button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//对出版社的注册进行检查，不能输入为空,不能注册已有的编号和名字
				if(fieldName.getText().equals("")||fieldUser.getText().equals("")||fieldID.equals(""))
					JOptionPane.showMessageDialog(null, "输入不能为空", "提示",JOptionPane.WARNING_MESSAGE);
				else 
					{
					if(servicePublish.register(new Publish(fieldID.getText(),fieldName.getText(),
					
							fieldUser.getText(),jc.getItemAt(jc.getSelectedIndex()))))
						JOptionPane.showMessageDialog(null, "注册成功", "提示",JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "注册失败", "提示",JOptionPane.WARNING_MESSAGE);
					}
				fieldID.setText("");
				fieldName.setText("");
				fieldUser.setText("");
				}
		});
       
    }   
    @Override
    protected void paintComponent(Graphics g1) {// 重写绘制组件外观
        Graphics2D g = (Graphics2D) g1;
        int width = getWidth();// 获取组件大小
        int height = getHeight();
        // 创建填充模式对象
        GradientPaint paint = new GradientPaint(20, 20, Color.CYAN, 0, height,
                Color.MAGENTA);
        g.setPaint(paint);// 设置绘图对象的填充模式
        g.fillRect(0, 0, width, height);// 绘制矩形填充控件界面
        g.setColor(Color.WHITE);
    	g.setFont(new Font("16",Font.BOLD,30));
		g.drawString("出版社注册", 40,50);
	    g.setColor(Color.white);
		g.setFont(new Font("20",Font.BOLD,20));
		g.drawString("书是人进步的阶梯",170, 80);
		g.setColor(Color.CYAN);
		g.drawString("出版社编号",100, 145);
		g.drawString("出版社名字",100, 195);
		g.drawString("领导者",100, 245);
		g.drawString("领导者性别", 100, 295);;
		g.drawImage(new ImageIcon("data/ImageIcon/icon-2.png").getImage(), 400, 30,this);
		
}
}
