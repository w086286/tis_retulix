package common.domain;

public class PagingVO {

	private int cpage= 1;
	private int pageSize= 10;
	private int totalCount;
	private int pageCount;
	
	private int start, end;
	
	private int pagingBlock= 10;
	private int prevBlock;
	private int nextBlock;
	
	private String selectBox;
	private String searchInput;
	
	public PagingVO() {
		
	}
	public PagingVO(int cpage, int pageSize, int pagingBlock) {
		this.cpage= cpage;
		this.pageSize= pageSize;
		this.pagingBlock= pagingBlock;		
	}
	public PagingVO(int totalCount, int cpage, int pageSize, int pagingBlock) {
		this.totalCount= totalCount;
		this.cpage= cpage;
		this.pageSize= pageSize;
		this.pagingBlock= pagingBlock;

		init();
	}

	public void init() {
		
		pageCount= (totalCount-1)/pageSize+1;
		if(cpage<1) {
			cpage=1;
		}
		if(cpage>pageCount) {
			cpage=pageCount;
		}
		
		end= cpage * pageSize;
		start= end - (pageSize - 1);
		
		prevBlock= ((cpage - 1) / pagingBlock) * pagingBlock;
		nextBlock= prevBlock + (pagingBlock + 1);
	}
	
	public String getPageNavi(String myctx, String loc, boolean isParam) {
		/* isParam==true: 검색타입, 검색어 파라미터로 넘길 때
		 * isParam==false: 파라미터 넘기지 않을 때 */
		selectBox= (selectBox==null)?"":selectBox;
		searchInput= (searchInput==null)?"":searchInput;
		
		String qStr="?selectBox="+selectBox+"&searchInput="+searchInput;	//false
		String qStr2="&selectBox="+selectBox+"&searchInput="+searchInput;	//true
		
		StringBuffer buffer= new StringBuffer();
		String str= null;
		
		if(isParam==false) {
			if(prevBlock>0) {
				buffer.append("<a href='"+myctx+"/"+loc+qStr+"&cpage="+prevBlock+"' class='page' style='margin-right:20px;'>Prev</a>");
			}
			
			for(int i=prevBlock+1; i<=nextBlock-1 && i<=pageCount; i++) {
				if(i==cpage) {
					buffer.append("<a href='#' class='page active'>"+i+"</a>");
				}
				else {
					buffer.append("<a href='"+myctx+"/"+loc+qStr+"&cpage="+i+"' class='page'>"+i+"</a>");
				}
			}
			
			if(nextBlock<=pageCount) {
				buffer.append("<a href='"+myctx+"/"+loc+qStr+"&cpage="+nextBlock+"' class='page' style='margin-left:20px;'>Next</a>");
			}
			
			str= buffer.toString();
			
		}
		else {
			if(prevBlock>0) {
				buffer.append("<a href='"+myctx+"/"+loc+qStr2+"&cpage="+prevBlock+"' class='page' style='margin-right:20px;'>Prev</a>");
			}
			
			for(int i=prevBlock+1; i<=nextBlock-1 && i<=pageCount; i++) {
				if(i==cpage) {
					buffer.append("<a href='#' class='page active'>"+i+"</a>");
				}
				else {
					buffer.append("<a href='"+myctx+"/"+loc+qStr2+"&cpage="+i+"' class='page'>"+i+"</a>");
				}
			}
			
			if(nextBlock<=pageCount) {
				buffer.append("<a href='"+myctx+"/"+loc+qStr2+"&cpage="+nextBlock+"' class='page' style='margin-left:20px;'>Next</a>");
			}
			
			str= buffer.toString();
			
		}
		return str;
	}
	
	
	public int getCpage() {
		return cpage;
	}
	public void setCpage(int cpage) {
		this.cpage = cpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPagingBlock() {
		return pagingBlock;
	}
	public void setPagingBlock(int pagingBlock) {
		this.pagingBlock = pagingBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public String getSelectBox() {
		return selectBox;
	}
	public void setSelectBox(String selectBox) {
		this.selectBox = selectBox;
	}
	public String getSearchInput() {
		return searchInput;
	}
	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}
	
}
