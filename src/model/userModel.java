package model;
/**
 * �û�ʵ����
 * @author DELL2017
 *����ʱ��:2020��6��17�� ����5:03:52
 */
public class userModel {
private int id;//���
private String userName;//�û���
private String password;//����





public userModel(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}
public userModel() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
