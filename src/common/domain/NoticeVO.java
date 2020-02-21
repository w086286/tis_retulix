package common.domain;

import java.util.Date;

public class NoticeVO {
	
	private int idx;
	private String title;
	private String info;
	private Date wdate;
	private int click;
	private String name;
	
	public NoticeVO() {
	}

	public NoticeVO(int idx, String title, String info, Date wdate, int click, String name) {
		super();
		this.idx = idx;
		this.title = title;
		this.info = info;
		this.wdate = wdate;
		this.click = click;
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
