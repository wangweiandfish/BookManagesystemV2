package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.StringUtil;
import model.BookInfo;

/**
 * ͼ����ϢDao
 * @author DELL2017
 *����ʱ��:2020��6��20�� ����3:26:07
 */
public class bookInfoDao {
	/**
	 *ͼ����Ϣ���
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
/**
 * ��ѯͼ����Ϣ����
 * @param con
 * @param bookinfo
 * @return
 */
public ResultSet list(Connection con,BookInfo bookinfo) throws Exception{
	StringBuffer sb=new StringBuffer("select * from t_bookinfo");
	if(StringUtil.isNotEmpty(bookinfo.getBookName())) {
		sb.append(" and bookName like '%"+bookinfo.getBookName()+"%'");
	}
	
		 
		 PreparedStatement presta = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return presta.executeQuery();
		
	
	//return null;
	
	
}
/**
 * ɾ��ͼ����Ϣ(��������ĳ����)
 * @param con
 * @param isbn
 * @return
 * @throws Exception
 */
public int delete(Connection con,String isbn)throws Exception{
	String sql="delete from t_bookinfo where isbn=?";
	PreparedStatement presta=con.prepareStatement(sql);
	presta.setString(1, isbn);
	return presta.executeUpdate();
	
}

/**
 * ͼ����Ϣ�ĸ���
 * @param con
 * @param bookinfo
 * @return
 * @throws Exception
 */
public int update(Connection con,BookInfo bookinfo)throws Exception
{
	String sql="update t_bookinfo set bookName=?,bookTypeName=?,author=?,`Desc`=? where isbn=?";
	PreparedStatement presta=con.prepareStatement(sql);
	presta.setString(1, bookinfo.getBookName());
	presta.setString(2, bookinfo.getBookTypeName());
	presta.setString(3, bookinfo.getAuthor());
	presta.setString(4, bookinfo.getDesc());
	
	presta.setString(5, bookinfo.getIsbn());
	
	
	return presta.executeUpdate();
	
	
}
}
