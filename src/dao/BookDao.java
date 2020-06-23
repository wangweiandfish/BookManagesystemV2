package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import Util.StringUtil;
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
/**
 * 查询图书类
 * @param con
 * @param book
 * @return
 * @throws Exception
 */
public ResultSet list(Connection con,Book book)throws Exception{
	StringBuffer sb=new StringBuffer("select * from t_book b,t_bookinfo bt where b.bookisbn=bt.isbn ");
	if(StringUtil.isNotEmpty(book.getBookisbn())) {
		sb.append("and b.bookisbn like '%"+book.getBookisbn()+"%'");
	}
	if(StringUtil.isNotEmpty(book.getBookName())) {
		sb.append("and b.bookName like '%"+book.getBookName()+"%'");
	}
	if(book.getId()!=0 && book.getId()!=-1) {
		//sb.append("and b.id like '%"+book.getId()+"%'");
		sb.append("and b.id="+book.getId());
	}
	PreparedStatement presta=con.prepareStatement(sb.toString());
	return presta.executeQuery();
}

public ResultSet newlist(Connection con,Book book)throws Exception{
	StringBuffer sb=new StringBuffer("select * from t_book");
	if(StringUtil.isNotEmpty(book.getBookisbn())) {
		sb.append("and bookisbn like '%"+book.getBookisbn()+"%'");
	}
	if(StringUtil.isNotEmpty(book.getBookName())) {
		sb.append("and bookName like '%"+book.getBookName()+"%'");
	}
	if(book.getId()!=0 && book.getId()!=-1) {
		sb.append("and `id`="+book.getId());
	}
	PreparedStatement presta=con.prepareStatement(sb.toString());
	return presta.executeQuery();
}
}
