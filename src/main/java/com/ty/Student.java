package com.ty;

public class Student {
    private int uname;
    private String uemail;
    private long uphone;
    private String ustd;
    private String upwd;
	public Student(int uname, String uemail, long uphone, String ustd, String upwd) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.uphone = uphone;
		this.ustd = ustd;
		this.upwd = upwd;
	}
	public Student(String uname, String uemail, long uphone, String ustd) {
		
	}
	public int getUname() {
		return uname;
	}
	
	public String getUemail() {
		return uemail;
	}
	
	public long getUphone() {
		return uphone;
	}
	
	public String getUstd() {
		return ustd;
	}
	
	public String getUpwd() {
		return upwd;
	}
	

    
}
