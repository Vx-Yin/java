package cn.edu.jsu.yao.dao;

import java.util.Vector;

import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.User;
/**
 * ���弸��VO��Ĺ��в���,�����׼
 * @author ������
 *
 * @param <VO>VO��Ķ���
 */
public interface IDAO <VO>{
	/**
	 * ����һ��VO����
	 * @param v ����
	 * @return true,false
	 */
	public boolean doCreate(VO v);
	/**
	 * �������е�VO����
	 * @return vector����
	 */
	public Vector<VO> get();
}
