package com.example.demo.AuthService;

public class LoginRequest {
	private String mail;
	private String passWord;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public LoginRequest(String mail, String passWord) {
		super();
		this.mail = mail;
		this.passWord = passWord;
	}
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
