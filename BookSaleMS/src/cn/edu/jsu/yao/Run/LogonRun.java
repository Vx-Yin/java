package cn.edu.jsu.yao.Run;

import cn.edu.jsu.yao.frm.JLogon;
/**
 * ��¼ʵ�ֶ��߳�
 * @author ������
 *
 */
public class LogonRun implements Runnable{
@Override
public void run() {
	// �û���¼
	new JLogon();
}
}