package cn.edu.jsu.yao.frm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 个人中心背景
 * @author 尹奥琪
 *
 */
public class CShade extends JPanel{
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
	}
	 
}
