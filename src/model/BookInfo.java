package model;
/**
 * 图书信息实体类
 * @author DELL2017
 *创建时间:2020年6月20日 下午3:01:10
 */
public class BookInfo {
private String isbn;//出版号
private String bookName;//图书名
private String bookTypeName;//图书类型
private String author;//作者
private int inStoreCount;//库存量
private String Desc;//描述


public BookInfo(String isbn, String bookName, String bookTypeName, String author, String desc) {
	super();
	this.isbn = isbn;
	this.bookName = bookName;
	this.bookTypeName = bookTypeName;
	this.author = author;
	Desc = desc;
}
public BookInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getBookTypeName() {
	return bookTypeName;
}
public void setBookTypeName(String bookTypeName) {
	this.bookTypeName = bookTypeName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getInStoreCount() {
	return inStoreCount;
}
public void setInStoreCount(int inStoreCount) {
	this.inStoreCount = inStoreCount;
}
public String getDesc() {
	return Desc;
}
public void setDesc(String desc) {
	Desc = desc;
}


}
