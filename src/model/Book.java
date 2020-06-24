package model;
/**
 * 图书实体类
 * @author DELL2017
 *创建时间:2020年6月22日 上午9:50:53
 */
public class Book {
private int id;//内部编号
private String bookName;//图书名(外键)
private double price;//图书价格
private String bookisbn;//图书出版号（外键)

public Book() {
	super();
	// TODO Auto-generated constructor stub
}

public Book(int id, String bookName, String bookisbn) {
	super();
	this.id = id;
	this.bookName = bookName;
	this.bookisbn = bookisbn;
}

public Book(int id, String bookName, double price) {
	super();
	this.id = id;
	this.bookName = bookName;
	this.price = price;
}

public Book(String bookName, double price, String bookisbn) {
	super();
	this.bookName = bookName;
	this.price = price;
	this.bookisbn = bookisbn;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getBookisbn() {
	return bookisbn;
}
public void setBookisbn(String bookisbn) {
	this.bookisbn = bookisbn;
}


}
