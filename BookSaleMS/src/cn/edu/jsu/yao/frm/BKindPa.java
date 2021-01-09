package cn.edu.jsu.yao.frm;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.yao.factory.ServiceFactory;
import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
/**
 * 种类界面
 * @author 尹奥琪
 *
 */
public class BKindPa extends JPanel{
	JButton button=new JButton("查询");
	IBookService service=ServiceFactory.getBookServiceImpl();//工厂类获取服务
	JScrollPane sp=null;
	JTable table=new JTable();
	JComboBox<String> kind=new JComboBox(service.getKind());
	public BKindPa() {
		super();
		setLayout(null);
		Vector<String> title=new Vector<String>();
		kind.setBounds(520,20,160,30);
		Collections.addAll(title, "作者","书名","类别","数目","价格","出版社","销售状态","时间");
		Vector<Vector> bookdata=new Vector<Vector>();//设置名字
		bookdata=service.findBook();
		DefaultTableModel model=new DefaultTableModel(bookdata,title);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//去掉重新设置大小功能
		table.getColumnModel().getColumn(7).setPreferredWidth(200); //设置表格大小
		sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		button.setBounds(700,20,80,30);
		sp.setBounds(90,70,700,500);//滚动面版的大小
		button.setContentAreaFilled(false);
		add(button);
		add(sp);
		add(kind);
		setBounds(0, 0,750, 650);//面板的大小
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> book=service.findKind(kind.getItemAt(kind.getSelectedIndex()));
				table.setModel(new DefaultTableModel(book,title));
				table.getColumnModel().getColumn(7).setPreferredWidth(200);
			}
		});
	}
	@Override
    protected void paintComponent(Graphics g1) {// 重写绘制组件外观
		   Graphics2D g = (Graphics2D) g1;
		   g.drawImage(new ImageIcon("data/ImageIcon/p-1.jpg").getImage(), 0, 0,this);
		   g.setFont(new Font("12",Font.BOLD,16));
		   g.drawString("种类:", 470, 40);
			}
}
