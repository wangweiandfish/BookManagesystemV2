package model;
/**
 * ͼ��ʵ����
 * @author DELL2017
 *����ʱ��:2020��6��22�� ����9:50:53
 */
public class Book {
private int id;//�ڲ����
private String bookName;//ͼ����(���)
private double price;//ͼ��۸�
private String bookisbn;//ͼ�����ţ����)

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
