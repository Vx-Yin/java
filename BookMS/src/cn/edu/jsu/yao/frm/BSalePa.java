package cn.edu.jsu.yao.frm;

import java.awt.Font;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.yao.Run.BuyBookFrRun;
import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
import cn.edu.jsu.yao.vo.Book;
/**
 * ���۹���
 * @author ������
 *
 */
public class BSalePa extends JPanel{
	public JButton button=new JButton("����");
	public JButton button2=new JButton("����");
	public JButton button3=new JButton("ˢ��");
	public JTextField text=new JTextField();
	public IBookService service=ServiceFactory.getBookServiceImpl();//�������ȡ����
	JScrollPane sp=null;
	JTable table=new JTable();
	JMenu menuS=new JMenu("���۳�ͼ��");
	JMenu menuUS=new JMenu("���۳�ͼ��");
	JMenu menuExit=new JMenu("�˳�");
	JMenuBar menuBar=new JMenuBar();
	JMenuItem ItemS=new JMenuItem("���۳�ͼ��");
	JMenuItem Item=new JMenuItem("����");
	JMenuItem Item2=new JMenuItem("����");
	JMenuItem ItemUS=new JMenuItem("���۳�ͼ��");
	DefaultTableModel model=null;//�������
	public BSalePa() {
		super();
		setLayout(null);
		Vector<String> title=new Vector<String>();
		Collections.addAll(title, "����","����","���","��Ŀ","�۸�","������","����״̬","ʱ��");
		Vector<Vector> bookdata=new Vector<Vector>();//��������
		bookdata=service.findBook();
		model=new DefaultTableModel(bookdata,title);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//ȥ���������ô�С����
		table.getColumnModel().getColumn(7).setPreferredWidth(200); //���ñ���С
		sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(90,70,700,500);//�������Ĵ�С
		button.setBounds(600,30,100,25);
		button.setContentAreaFilled(false);
		button2.setBounds(470,30,100,25);
		button2.setContentAreaFilled(false);
		button3.setBounds(340,30,100,25);
		button3.setContentAreaFilled(false);
		text.setBounds(720,30,100,25);
		setBounds(0, 0, 750, 650);//���Ĵ�С
		menuBar.add(menuS);
		menuBar.add(menuUS);
		menuS.add(ItemS);
		menuS.add(Item);
		menuUS.add(ItemUS);
		menuUS.add(Item2);
		menuBar.add(menuExit);
		add(button);
		add(button2);
		add(button3);
		add(text);
		add(sp);
//      setLayout(null);
//      tp.setBounds(100,100,400,400);
		add(menuBar);
		menuBar.setBounds(0,0,190,20);
		/*
		 * �����¼�
		 */
		//�������ѯ
		ItemUS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findSale("true");
				model=new DefaultTableModel(book,title);
				table.setModel(model);
				table.getColumnModel().getColumn(7).setPreferredWidth(200);
			}
		});
		ItemS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<Vector> book=service.findSale("false");
				model=new DefaultTableModel(book,title);
				table.setModel(model);
				table.getColumnModel().getColumn(7).setPreferredWidth(200);
			}
		});
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if(row==-1)
					JOptionPane.showMessageDialog(null, "δѡ���κ�һ��", "����",JOptionPane.WARNING_MESSAGE);
				else
				{
				Book b=new Book();
				Vector data=getSelect(row);
				if(data==null)
					JOptionPane.showMessageDialog(null, "δѡ�����۵�ͼ��", "����",JOptionPane.WARNING_MESSAGE);
				else {
					b.setAuthor((String)data.get(0));
					b.setBookName((String)data.get(1));
					b.setKind((String)data.get(2));
					b.setNumber((int)data.get(3));
					b.setPrice((double)data.get(4));
					b.setPublishName((String)data.get(5));
					b.setSale((String) data.get(6));
					b.setTime((String)data.get(7));
					String td=text.getText();
					if(!isNumeric(td))
						JOptionPane.showMessageDialog(null, "�������Ϊ����", "����",JOptionPane.WARNING_MESSAGE);
					else if(td.length()>5) {
						JOptionPane.showMessageDialog(null, "��Ŀ����", "����",JOptionPane.WARNING_MESSAGE);
					}
					else if(td.length()==0)
						JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "����",JOptionPane.WARNING_MESSAGE);
					else{
					int number=Integer.valueOf(td);
					if(service.sale(b, number))
						{
						 JOptionPane.showMessageDialog(null, "���۳ɹ�", "��ʾ",JOptionPane.WARNING_MESSAGE);
						 model=new DefaultTableModel( service.findBook(),title);
						 table.setModel(model);
						}
					else
						JOptionPane.showMessageDialog(null, "����ʧ��", "��ʾ",JOptionPane.WARNING_MESSAGE);
					table.getColumnModel().getColumn(7).setPreferredWidth(200);
				}
				}
			}
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread t=new Thread(new BuyBookFrRun());
				t.start();
			}
		});
		button3.addActionListener(new ActionListener() {
			//���¶�ȡ���ݣ�ˢ�£���ĿΪ���ͼ���Զ�ɾ��
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> book=service.findBook();
				service.delete();
				model=new DefaultTableModel(book,title);
				table.setModel(model);
				table.getColumnModel().getColumn(7).setPreferredWidth(200);
			}
		});
	}
	public Vector getSelect(int row) {
		Vector book=new Vector<Vector>();
		if(table.getValueAt(row, 6).equals("false"))
			return null;
		for(int i=0;i<8;i++)
			  book.add(table.getValueAt(row, i));
			
		return book;
	}
	public static boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
				}
			}return true;}
	@Override
    protected void paintComponent(Graphics g1) {// ��д����������
		   Graphics2D g = (Graphics2D) g1;
		   g.drawImage(new ImageIcon("data/ImageIcon/p-1.jpg").getImage(), 0, 0,this);
			}
}
