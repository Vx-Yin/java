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
 * �������ı���
 * @author ������
 *
 */
public class CShade extends JPanel{
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
	}
	 
}
