package cn.edu.jsu.yao.service;

import java.util.Vector;

import cn.edu.jsu.yao.vo.Publish;

/**
 * 定义出版社在业务的需求标准
 * @author 尹奥琪
 *
 */
public interface IPublishService {
	/**
	 * 出版社注册
	 * @param publish 出版社
	 * @return 成功返回true,失败返回false
	 */
	public Boolean register(Publish publish);
	/**
	 * 获取出版社的所有信息
	 * @return 出版社的集合
	 */
	public Vector<Vector<String>> getall();
	/**
	 * 获取出版社的名字
	 * @return vector类，出版社
	 */
	public Vector<String> getPublishName();
}
