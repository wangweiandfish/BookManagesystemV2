package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Book;

/**
 * 图书Dao
 * @author DELL2017
 *创建时间:2020年6月22日 上午10:05:04
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
