package com.dev.beans;

public class Student {

	private Integer stud_id;
	private String name;
	private String email;
	private String password;
	
	public Integer getStud_id() {
		return stud_id;
	}
	public void setStud_id(Integer stud_id) {
		this.stud_id = stud_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
