package model;
/**
 * ͼ����Ϣʵ����
 * @author DELL2017
 *����ʱ��:2020��6��20�� ����3:01:10
 */
public class BookInfo {
private String isbn;//�����
private String bookName;//ͼ����
private String bookTypeName;//ͼ������
private String author;//����
private int inStoreCount;//�����
private String Desc;//����


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
