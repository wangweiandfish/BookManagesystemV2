package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Book;

/**
 * ͼ��Dao
 * @author DELL2017
 *����ʱ��:2020��6��22�� ����10:05:04
 */
public class BookDao {
public int add(Connection con,Book book)throws Exception{
	String sql="insert into t_book values(null,?,?,?)";
	PreparedStatement presta=con.prepareStatement(sql);
	presta.setString(1, book.getBookName());
	presta.setDouble(2, book.getPrice());
	presta.setString(3, book.getBookisbn());
	
	
	return presta.executeUpdate();
	
}
}
