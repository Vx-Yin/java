package cn.edu.jsu.yao.dao;

import java.util.Vector;

import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.Publish;

/**
 * 数据层操作标准,出版社
 * @author 尹奥琪
 *
 */
public interface PublishIDAO extends IDAO<Publish>{
	@Override
	/**
	 * 创建一个出版社,首先要判断是否存在
	 * @param publish 出版社
	 * @return 成功返回true，失败返回false
	 */
	public boolean doCreate(Publish publish);
	@Override
	/**
	 * 得到所有的出版社
	 * @return 成功返回true,失败返回false
	 */
	public Vector<Publish> get();
	/**
	 * 按照指定的出版名查找
	 * @param publisName 出版社
	 * @return 成功返回true,失败返回false
	 */
	public boolean find(String publisName);
	/**
	 * 按照指定的序号查找，判断是否存在
	 * @param publisId 出版社序号
	 * @return true,false
	 */
	public boolean findId(String publisId);
	/**
	 * 获得所有出版社的名字
	 * @return 出版社的集合
	 */
	public Vector<String> getPublisName();
}
