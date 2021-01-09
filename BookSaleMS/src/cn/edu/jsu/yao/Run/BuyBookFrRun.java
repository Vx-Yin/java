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
 * 多线程，开启一个新的买书界面。
 * @author 尹奥琪
 *
 */
public class BuyBookFrRun implements Runnable{
	@Override
	public void run() {
		JFrame f=new JFrame("买书");
		BuyBookPa b=new BuyBookPa();
		f.add(b);
		f.setBounds(60,120,750,500);
		b.button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置退出按钮
				f.dispose();
			}
		});
		b.button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//用户交互，用户不能输入空的内容,已经在数据库实现了买书操作，因为主键是时间和书名和销售状态，所以可以加入相同书名的图书，出版社以及种类只可以选择，还需判断整数
					if(b.text[0].getText().equals("")||b.text[1].getText().equals("")||b.text[4].getText().equals("")||
							b.text[5].getText().equals("")||b.comKind.getItemAt(b.comKind.getSelectedIndex()).equals("")||
							b.comKind.getItemAt(b.comPublish.getSelectedIndex()).equals(""))
						JOptionPane.showMessageDialog(null, "输入不能为空", "提示",JOptionPane.WARNING_MESSAGE);
					else if(!(BSalePa.isNumeric(b.text[4].getText())||BSalePa.isNumeric(b.text[5].getText())))
						JOptionPane.showMessageDialog(null, "价格或数量必须为整数", "提示",JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "注册成功", "提示",JOptionPane.WARNING_MESSAGE);
					f.dispose();
					}
					
			}
		});
		f.setVisible(true);
	}
}
