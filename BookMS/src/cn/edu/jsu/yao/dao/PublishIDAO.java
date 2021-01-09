package cn.edu.jsu.yao.dao;

import java.util.Vector;

import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.Publish;

/**
 * ���ݲ������׼,������
 * @author ������
 *
 */
public interface PublishIDAO extends IDAO<Publish>{
	@Override
	/**
	 * ����һ��������,����Ҫ�ж��Ƿ����
	 * @param publish ������
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean doCreate(Publish publish);
	@Override
	/**
	 * �õ����еĳ�����
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public Vector<Publish> get();
	/**
	 * ����ָ���ĳ���������
	 * @param publisName ������
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean find(String publisName);
	/**
	 * ����ָ������Ų��ң��ж��Ƿ����
	 * @param publisId ���������
	 * @return true,false
	 */
	public boolean findId(String publisId);
	/**
	 * ������г����������
	 * @return ������ļ���
	 */
	public Vector<String> getPublisName();
}
