package cn.edu.jsu.yao.factory;

import cn.edu.jsu.yao.service.IBookService;
import cn.edu.jsu.yao.service.IPublishService;
import cn.edu.jsu.yao.service.IUserService;
import cn.edu.jsu.yao.service.impl.BookServiceImpl;
import cn.edu.jsu.yao.service.impl.PublishServiceImpl;
import cn.edu.jsu.yao.service.impl.UserServiceImpl;

/**
 * ¾²Ì¬¹¤³§Àà
 * @author Òü°Âç÷
 *
 */
public class ServiceFactory {
    public static IBookService getBookServiceImpl() {
		return new BookServiceImpl();
    }
    public static IPublishService getPublishServiceImpl() {
  		return new PublishServiceImpl();
      }
    public static IUserService getUserServiceImpl() {
  		return new UserServiceImpl();
      }
}
