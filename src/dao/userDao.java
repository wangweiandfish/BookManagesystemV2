package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.userModel;

/**
 * �û�Dao��
 * @author DELL2017
 *����ʱ��:2020��6��17�� ����5:22:08
 */
public class userDao {
	/**��¼��֤
	 * 
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
public userModel login(Connection con,userModel user) throws SQLException {
	userModel resultuser=null;
	String sql="select * from t_user where userName=? and password=?";
	PreparedStatement presta=con.prepareStatement(sql);
	presta.setString(1, user.getUserName());
	presta.setString(2, user.getPassword());
	ResultSet set= presta.executeQuery();
	if(set.next()) {
		resultuser=new userModel();//ʵ����
		resultuser.setId(set.getInt("id"));
		resultuser.setUserName(set.getString("userName"));
		resultuser.setPassword(set.getString("password"));
		
	}
	return resultuser;
	
}
}
