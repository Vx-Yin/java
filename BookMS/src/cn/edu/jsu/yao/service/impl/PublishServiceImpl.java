package cn.edu.jsu.yao.service.impl;

import java.util.Collections;

import java.util.Vector;

import cn.edu.jsu.yao.dao.impl.BookDAOImpl;
import cn.edu.jsu.yao.dao.impl.PublishDAOImpl;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.factory.DAOFactory;
import cn.edu.jsu.yao.service.IPublishService;
import cn.edu.jsu.yao.vo.Book;
import cn.edu.jsu.yao.vo.Publish;
/**
 * �������йز�����ҵ���,ʵ����صĹ��ܷ���
 * @author ������
 *
 */
public class PublishServiceImpl implements IPublishService{
	private DatabaseConnection dbc=null;//�������ݿ�����
    public PublishServiceImpl() {
		dbc=new DatabaseConnection();
	}
	@Override
	public Boolean register(Publish publish) {
	 return DAOFactory.getPublishIDAOImpl(dbc.getConnection()).doCreate(publish);
	}
	@Override
	public Vector<Vector<String>> getall() {
		Vector<Publish> pd=DAOFactory.getPublishIDAOImpl(dbc.getConnection()).get();
		Vector<Vector<String>> pdata=new Vector<Vector<String>>();
		for(int i=0;i<pd.size();i++)
			{
			Vector row=new Vector<String>();
			Publish publish=pd.get(i);
			Collections.addAll(row,publish.getPublisId(),publish.getPublisName(),publish.getLeader(),publish.getSex());
			pdata.add(row);
			}
		return pdata;
	}
	@Override
	public Vector<String> getPublishName() {
	   return DAOFactory.getPublishIDAOImpl(dbc.getConnection()).getPublisName();
	}
}
