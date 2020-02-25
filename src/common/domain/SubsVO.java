package common.domain;

import java.io.Serializable;

public class SubsVO implements Serializable{
	private String email;
	private String email_subs;
	
	public SubsVO() {
	}
	
	public SubsVO(String email, String idx) {
		super();
		this.email = email;
		this.email_subs = idx;
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

}
