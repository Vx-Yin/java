package cn.edu.jsu.yao.frm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 登录的背景
 * @author 尹奥琪
 *
 */
public class LShade extends JPanel{
	public LShade() {
        super();
        setLayout(null);
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
	    	g.setFont(new Font("16",Font.BOLD,50));
			g.drawString("图书销售", 100, 80);
		    g.setColor(Color.CYAN);
			g.setFont(new Font("20",Font.BOLD,30));
			g.drawString("管理系统",320, 130);
}
}