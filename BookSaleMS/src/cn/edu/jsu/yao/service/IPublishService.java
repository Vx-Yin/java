package cn.edu.jsu.yao.service;

import java.util.Vector;

import cn.edu.jsu.yao.vo.Publish;

/**
 * �����������ҵ��������׼
 * @author ������
 *
 */
public interface IPublishService {
	/**
	 * ������ע��
	 * @param publish ������
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public Boolean register(Publish publish);
	/**
	 * ��ȡ�������������Ϣ
	 * @return ������ļ���
	 */
	public Vector<Vector<String>> getall();
	/**
	 * ��ȡ�����������
	 * @return vector�࣬������
	 */
	public Vector<String> getPublishName();
}
