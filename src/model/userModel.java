package model;
/**
 * 用户实体类
 * @author DELL2017
 *创建时间:2020年6月17日 下午5:03:52
 */
public class userModel {
private int id;//编号
private String userName;//用户名
private String password;//密码





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
