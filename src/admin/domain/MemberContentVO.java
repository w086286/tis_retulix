package admin.domain;

import java.util.Date;

public class MemberContentVO {
	
	private String idx;
	private String email;
	private String name;
	private String trailerTitle;
	private String reviewTitle;
	private String info;
	private String url;
	private Date wdate;
	
	public MemberContentVO() {
		
	}
	public MemberContentVO(String idx, String email, String name, String trailerTitle, String reviewTitle, String info,
			String url, Date wdate) {
		super();
		this.idx = idx;
		this.email = email;
		this.name = name;
		this.trailerTitle = trailerTitle;
		this.reviewTitle = reviewTitle;
		this.info = info;
		this.url = url;
		this.wdate = wdate;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
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
	public String getTrailerTitle() {
		return trailerTitle;
	}
	public void setTrailerTitle(String trailerTitle) {
		this.trailerTitle = trailerTitle;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	


}
