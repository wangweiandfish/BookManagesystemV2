package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.BookInfo;

/**
 * 图书信息Dao
 * @author DELL2017
 *创建时间:2020年6月20日 下午3:26:07
 */
public class bookInfoDao {
	/**
	 *图书信息添加
	 * @param con
	 * @param info
	 * @return
	 */
public int add(Connection con,BookInfo info) {
	String sql="insert into t_bookinfo values(?,?,?,?,0,?)";
	
	try {
		PreparedStatement presta=con.prepareStatement(sql);
		presta.setString(1, info.getIsbn());
		presta.setString(2, info.getBookName());
		presta.setString(3, info.getBookTypeName());
		presta.setString(4, info.getAuthor());
		//presta.setInt(5, 0);
		presta.setString(5, info.getDesc());
		return presta.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}
}
