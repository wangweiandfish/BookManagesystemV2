package Util;
/**
 * ���ݿ�Ĺ�����
 * @author DELL2017
 *����ʱ��:2020��6��17�� ����11:10:19
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dBUtil {
private String dbUrl="jdbc:mysql://localhost:3306/db_book?serverTimezone=UTC";//���ݿ����ӵ�ַ

private String dbUserName="root";//�û���
private String dbPassword="ww1521491171";//����
private String jdbcName="com.mysql.cj.jdbc.Driver";

public Connection getCon() throws ClassNotFoundException, SQLException {
	getClass();
	Class.forName(jdbcName);
	Connection con=DriverManager.getConnection(dbUrl, dbUserName,dbPassword);//��ȡ���ݿ�����
	return con;
	
}
/**
 * �ر����ݿ�����
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
		System.out.println("���ݿ����ӳɹ�");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("���ݿ�����ʧ��");
	}
}
}
