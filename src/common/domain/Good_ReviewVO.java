package common.domain;

import java.io.Serializable;

public class Good_ReviewVO implements Serializable{
	
	private String email;
	private String idx;
	
	public Good_ReviewVO() {
	}
	
	public Good_ReviewVO(String email, String idx) {
		super();
		this.email = email;
		this.idx = idx;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	
}
