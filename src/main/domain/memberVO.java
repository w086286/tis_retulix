package main.domain;

import java.io.Serializable;

public class memberVO implements Serializable {
	
	private String email;
	private String name;
	private int age;
	private String pwd;
	private int point;
	private int state;
	
	
	public memberVO() {
		
	}
	
	public memberVO(String email, String email_subs, int s_idk, String name, int age, String pwd, int point, int state) {
		super();
		this.email = email;
		this.name = name;
		this.age = age;
		this.pwd = pwd;
		this.point = point;
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	

}
