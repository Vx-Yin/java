package cn.edu.jsu.yao.dao;

import java.util.Vector;

import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.User;
/**
 * 定义几个VO类的共有操作,定义标准
 * @author 尹奥琪
 *
 * @param <VO>VO类的对象
 */
public interface IDAO <VO>{
	/**
	 * 创建一个VO对象
	 * @param v 对象
	 * @return true,false
	 */
	public boolean doCreate(VO v);
	/**
	 * 返回所有的VO数据
	 * @return vector集合
	 */
	public Vector<VO> get();
}
