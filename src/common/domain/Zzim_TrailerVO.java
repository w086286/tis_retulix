package common.domain;

import java.io.Serializable;

public class Zzim_TrailerVO implements Serializable{
	
	private String email;
	private String idx;
	
	public Zzim_TrailerVO() {
	}
	
	public Zzim_TrailerVO(String email, String idx) {
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
