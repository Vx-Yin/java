package cn.edu.jsu.yao.Run;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.yao.dao.impl.BookDAOImpl;
import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.frm.BSalePa;
import cn.edu.jsu.yao.frm.BuyBookPa;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
import cn.edu.jsu.yao.vo.Book;
/**
 * ���̣߳�����һ���µ�������档
 * @author ������
 *
 */
public class BuyBookFrRun implements Runnable{
	@Override
	public void run() {
		JFrame f=new JFrame("����");
		BuyBookPa b=new BuyBookPa();
		f.add(b);
		f.setBounds(60,120,750,500);
		b.button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�����˳���ť
				f.dispose();
			}
		});
		b.button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//�û��������û���������յ�����,�Ѿ������ݿ�ʵ���������������Ϊ������ʱ�������������״̬�����Կ��Լ�����ͬ������ͼ�飬�������Լ�����ֻ����ѡ�񣬻����ж�����
					if(b.text[0].getText().equals("")||b.text[1].getText().equals("")||b.text[4].getText().equals("")||
							b.text[5].getText().equals("")||b.comKind.getItemAt(b.comKind.getSelectedIndex()).equals("")||
							b.comKind.getItemAt(b.comPublish.getSelectedIndex()).equals(""))
						JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��ʾ",JOptionPane.WARNING_MESSAGE);
					else if(!(BSalePa.isNumeric(b.text[4].getText())||BSalePa.isNumeric(b.text[5].getText())))
						JOptionPane.showMessageDialog(null, "�۸����������Ϊ����", "��ʾ",JOptionPane.WARNING_MESSAGE);
					else
					{
					Book book=new Book();
					book.setKind(b.comKind.getItemAt(b.comKind.getSelectedIndex()));
					book.setPublishName(b.comPublish.getItemAt(b.comKind.getSelectedIndex()));
					book.setBookName(b.text[0].getText());
					book.setAuthor(b.text[1].getText());
					book.setPrice(Double.parseDouble(b.text[4].getText())) ;
					book.setNumber(Integer.valueOf(b.text[5].getText()));
					ServiceFactory.getBookServiceImpl().buy(book);
					JOptionPane.showMessageDialog(null, "ע��ɹ�", "��ʾ",JOptionPane.WARNING_MESSAGE);
					f.dispose();
					}
					
			}
		});
		f.setVisible(true);
	}
}
