package trailer_view.domain2;

import java.io.Serializable;

public class Trailer_view2 implements Serializable { 
	private String idx;
	private String title;
	
	
	public Trailer_view2() {}


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


	public Trailer_view2(String idx, String title) {
		super();
		this.idx = idx;
		this.title = title;
	}



}