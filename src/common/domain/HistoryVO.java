package common.domain;

import java.io.Serializable;

public class HistoryVO implements Serializable{
	private String email;
	private String idx;
	
	public HistoryVO() {
	}
	
	public HistoryVO(String email, String idx) {
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
