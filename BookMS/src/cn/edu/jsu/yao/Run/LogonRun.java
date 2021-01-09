package cn.edu.jsu.yao.Run;

import cn.edu.jsu.yao.frm.JLogon;
/**
 * 登录实现多线程
 * @author 尹奥琪
 *
 */
public class LogonRun implements Runnable{
@Override
public void run() {
	// 用户登录
	new JLogon();
}
}