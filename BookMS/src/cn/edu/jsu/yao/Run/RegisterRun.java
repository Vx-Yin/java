package cn.edu.jsu.yao.Run;

import cn.edu.jsu.yao.frm.JRegister;

public class RegisterRun implements Runnable{
	
	@Override
	public void run() {
		new JRegister();
		
	}

}
