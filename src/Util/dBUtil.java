package Util;
/**
 * 数据库的工具类
 * @author DELL2017
 *创建时间:2020年6月17日 上午11:10:19
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dBUtil {
private String dbUrl="jdbc:mysql://localhost:3306/db_book?serverTimezone=UTC";//数据库连接地址

private String dbUserName="root";//用户名
private String dbPassword="ww1521491171";//密码
private String jdbcName="com.mysql.cj.jdbc.Driver";

public Connection getCon() throws ClassNotFoundException, SQLException {
	getClass();
	Class.forName(jdbcName);
	Connection con=DriverManager.getConnection(dbUrl, dbUserName,dbPassword);//获取数据库连接
	return con;
	
}
/**
 * 关闭数据库连接
 * @param con
 */
public void closeDbCon(Connection con) {
	if(con!=null) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public static void main(String[] args) {
	dBUtil dbutil=new dBUtil();
	try {
		dbutil.getCon();
		System.out.println("数据库连接成功");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("数据库连接失败");
	}
}
}
