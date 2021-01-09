package cn.edu.jsu.yao.factory;

import java.sql.Connection;

import cn.edu.jsu.yao.dao.BookIDAO;
import cn.edu.jsu.yao.dao.PublishIDAO;
import cn.edu.jsu.yao.dao.UserIDAO;
import cn.edu.jsu.yao.dao.impl.BookDAOImpl;
import cn.edu.jsu.yao.dao.impl.PublishDAOImpl;
import cn.edu.jsu.yao.dao.impl.UserDAOImpl;

/**
 * ¾²Ì¬¹¤³§Àà
 * @author Òü°Âç÷
 *
 */
public class DAOFactory {
	public static BookIDAO getBookIDAOImpl(Connection conn) {
		return new BookDAOImpl(conn);
	}
	public static PublishIDAO getPublishIDAOImpl(Connection conn) {
		return new PublishDAOImpl(conn);
	}
	public static UserIDAO getUserIDAOImpl() {
		return new UserDAOImpl();
	}
}
