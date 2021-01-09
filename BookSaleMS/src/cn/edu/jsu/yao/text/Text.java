package cn.edu.jsu.yao.text;

import java.sql.Connection;

import cn.edu.jsu.yao.Run.LogonRun;
import cn.edu.jsu.yao.dbc.DatabaseConnection;
import cn.edu.jsu.yao.factory.DAOFactory;
import cn.edu.jsu.yao.vo.Publish;
import cn.edu.jsu.yao.factory.*;
public class Text {
	Connection conn=new DatabaseConnection().getConnection();
	public static void main(String[] args) {
		new Thread(new LogonRun()).start();;
}
}
