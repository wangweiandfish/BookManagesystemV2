package dao;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

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

//public ResultSet newlist(Connection con,Book book)throws Exception{
//	StringBuffer sb=new StringBuffer("select * from t_book");
//	if(StringUtil.isNotEmpty(book.getBookisbn())) {
//		sb.append("and bookisbn like '%"+book.getBookisbn()+"%'");
//	}
//	if(StringUtil.isNotEmpty(book.getBookName())) {
//		sb.append("and bookName like '%"+book.getBookName()+"%'");
//	}
//	if(book.getId()!=0 && book.getId()!=-1) {
//		sb.append("and `id`="+book.getId());
//	}
//	PreparedStatement presta=con.prepareStatement(sb.toString());
//	return presta.executeQuery();
//}
/**
 * 图书对象出库
 * @param con
 * @param id
 * @return
 * @throws Exception
 */
public int delete(Connection con,String id)throws Exception{
	String sql="delete from t_book where id=?";
	PreparedStatement presta=con.prepareStatement(sql);
	presta.setString(1, id);
	return presta.executeUpdate();
}
/**
 * 图书对象更新
 * @param con
 * @param book
 * @return
 * @throws Exception
 */
public int update(Connection con,Book book)throws Exception {
	String sql="update t_book set bookName=?,price=? where id=?";
	PreparedStatement presta=con.prepareStatement(sql);
	presta.setString(1, book.getBookName());
	presta.setDouble(2, book.getPrice());
	presta.setInt(3, book.getId());
	return presta.executeUpdate();
}

/**
 * 该图书出版号下是否有图书
 * @param con
 * @param isbn
 * @return
 * @throws Exception
 */
public boolean isExistBookByIsbn(Connection con,String isbn)throws Exception{
	String sql="select * from t_book where bookisbn=?";
	PreparedStatement presta=con.prepareStatement(sql);
	presta.setString(1, isbn);
	ResultSet rs=presta.executeQuery();
	return rs.next();
}
}
