package channel.domain;

import java.io.Serializable;
import java.util.Date;

public class StatVO implements Serializable{
	
	private String idx;
	private String title;
	private String url;
	private String info;
	private int good;
	private int click;
	private int zzim;
	private int subs;
	private String email;
	private String name;
	private java.util.Date wdate;
	private String t_title;
	private String t_idx;
	
	public StatVO() {
		
	}

	public StatVO(String idx, String title, String url, String info, int good, int click, int zzim, int subs,
			String email, String name, Date wdate, String t_title, String t_idx) {
		super();
		this.idx = idx;
		this.title = title;
		this.url = url;
		this.info = info;
		this.good = good;
		this.click = click;
		this.zzim = zzim;
		this.subs = subs;
		this.email = email;
		this.name = name;
		this.wdate = wdate;
		this.t_title = t_title;
		this.t_idx = t_idx;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
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

	public int getSubs() {
		return subs;
	}

	public void setSubs(int subs) {
		this.subs = subs;
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

	public java.util.Date getWdate() {
		return wdate;
	}

	public void setWdate(java.util.Date wdate) {
		this.wdate = wdate;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_idx() {
		return t_idx;
	}

	public void setT_idx(String t_idx) {
		this.t_idx = t_idx;
	}
	
}
