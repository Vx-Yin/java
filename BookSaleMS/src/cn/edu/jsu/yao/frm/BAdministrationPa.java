package cn.edu.jsu.yao.frm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice.Factory;
import com.mysql.cj.protocol.ServerCapabilities;

import cn.edu.jsu.yao.dao.impl.BookDAOImpl;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
import cn.edu.jsu.yao.vo.Book;
/**
 * ͼ�����
 * @author ������
 *
 */
public class BAdministrationPa extends JScrollPane{
	IBookService service=ServiceFactory.getBookServiceImpl();//�������ȡ����
	JScrollPane sp=null;
	JTextField sca=new JTextField();//�����
	JTable table=new JTable();
	JMenu menuFP=new JMenu("��ѯ������");
	JMenu menuFT=new JMenu("��ѯ����");
	JMenu menuFA=new JMenu("��ѯ����");
	JMenu menuFPr=new JMenu("��ѯ�۸�");
	JMenu menuFN=new JMenu("��ѯ����");
	JMenu menuExit=new JMenu("�˳�");
	JMenuBar menuBar=new JMenuBar();
	JMenuItem ItemPr=new JMenuItem("��ѯ�۸�");
	JMenuItem ItemN=new JMenuItem("��ѯ����");
	JMenuItem ItemP=new JMenuItem("��ѯ������");
	JMenuItem ItemT=new JMenuItem("��ѯ����");
	JMenuItem ItemA=new JMenuItem("��ѯ����");
	public BAdministrationPa(){
		super();
		setLayout(null);
		Vector<String> title=new Vector<String>();
		Collections.addAll(title, "����","����","���","��Ŀ","�۸�","������","����״̬","ʱ��");
		Vector<Vector> bookdata=new Vector<Vector>();//��������
		bookdata=service.findBook();
		DefaultTableModel model=new DefaultTableModel(bookdata,title);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//ȥ���������ô�С����
		table.getColumnModel().getColumn(7).setPreferredWidth(200); //���ñ���С
		sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(90,70,700,500);//�������Ĵ�С
		add(sp);
		setBounds(0, 0, 750, 650);//���Ĵ�С
		sca.setBounds(700,40,140,20);
		menuFN.add(ItemN);
		menuFN.add(new JMenuItem("����"));
		menuFT.add(ItemT);
		menuFT.add(new JMenuItem("����"));
		menuFPr.add(ItemPr);
		menuFPr.add(new JMenuItem("����"));
		menuFP.add(ItemP);
		menuFP.add(new JMenuItem("����"));
		menuFA.add(ItemA);
		menuFA.add(new JMenuItem("����"));
		menuBar.add(menuFN);
		menuBar.add(menuFPr);
		menuBar.add(menuFT);
		menuBar.add(menuFA);
		menuBar.add(menuFP);
		menuBar.add(menuExit);
		add(menuBar);
		add(sca);
		menuBar.setBounds(0,0,360,20);
		/*
		 * �����¼�
		 */
		//�������ѯ
		ItemP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> book=service.findPublish(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //���ñ���С
			}
		});
		//���߲�ѯ
		ItemA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> book=service.findAuthor(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //���ñ���С
			}
		});
		ItemT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findTime(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //���ñ���С
			}
		});
		ItemN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findBookName(sca.getText());
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200); //���ñ���С
			}
		});
		ItemPr.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double d=Double.parseDouble(sca.getText());
		Vector<Vector> book=service.findBookPrice(d);
		table.setModel(new DefaultTableModel(book,title));
		table.getColumnModel().getColumn(7).setPreferredWidth(200); //���ñ���С
	}
});
	}
	@Override
    protected void paintComponent(Graphics g1) {// ��д����������
		   Graphics2D g = (Graphics2D) g1;
		   g.drawImage(new ImageIcon("data/ImageIcon/p-1.jpg").getImage(), 0, 0,this);
		   g.setFont(new Font("12",Font.BOLD,14));
		   g.drawString("��ѯ:", 650, 55);
			}
}
