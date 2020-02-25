package common.domain;

import java.io.Serializable;
import java.util.Date;

public class ReviewVO implements Serializable{
	
	private String div;    
	private String genre;    
	private String num;    
	private String idx;   
	private String title;  
	private String url;  
	private String info; 
	private int good;     
	private int click;     
	private int zzim;     
	private String email;  
	private String t_idx;   
	private Date wdate;
	
	public ReviewVO() {
	}
	
	public ReviewVO(String div, String genre, String num, String idx, String title, String url, String info, int good,
			int click, int zzim, String email, String t_idx, Date wdate) {
		super();
		this.div = div;
		this.genre = genre;
		this.num = num;
		this.idx = idx;
		this.title = title;
		this.url = url;
		this.info = info;
		this.good = good;
		this.click = click;
		this.zzim = zzim;
		this.email = email;
		this.t_idx = t_idx;
		this.wdate = wdate;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getIdx() {
		return this.idx = div+genre+num;
	}

	public void setIdx(String idx) {
		this.idx = div+genre+num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public int getZzim() {
		return zzim;
	}

	public void setZzim(int zzim) {
		this.zzim = zzim;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getT_idx() {
		return t_idx;
	}

	public void setT_idx(String t_idx) {
		this.t_idx = t_idx;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	
}
