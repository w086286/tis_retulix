package main.domain;

import java.io.Serializable;

public class subscribeVO implements Serializable {
	private String email;
	private String email_subs;
	private int s_idk;
	
	public subscribeVO() {
		
	}
	public subscribeVO(String email, String email_subs, int s_idk) {
		super();
		this.email = email;
		this.email_subs = email_subs;
		this.s_idk = s_idk;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_subs() {
		return email_subs;
	}
	public void setEmail_subs(String email_subs) {
		this.email_subs = email_subs;
	}
	public int getS_idk() {
		return s_idk;
	}
	public void setS_idk(int s_idk) {
		this.s_idk = s_idk;
	}
	
	
	
}
