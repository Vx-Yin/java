package cn.edu.jsu.yao.frm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * ��¼�ı���
 * @author ������
 *
 */
public class LShade extends JPanel{
	public LShade() {
        super();
        setLayout(null);
    }   
    @Override
    protected void paintComponent(Graphics g1) {// ��д����������
	     Graphics2D g = (Graphics2D) g1;
	        int width = getWidth();// ��ȡ�����С
	        int height = getHeight();
	        // �������ģʽ����
	        GradientPaint paint = new GradientPaint(20, 20, Color.CYAN, 0, height,
	                Color.MAGENTA);
	        g.setPaint(paint);// ���û�ͼ��������ģʽ
	        g.fillRect(0, 0, width, height);// ���ƾ������ؼ�����
	        g.setColor(Color.WHITE);
	    	g.setFont(new Font("16",Font.BOLD,50));
			g.drawString("ͼ������", 100, 80);
		    g.setColor(Color.CYAN);
			g.setFont(new Font("20",Font.BOLD,30));
			g.drawString("����ϵͳ",320, 130);
}
}