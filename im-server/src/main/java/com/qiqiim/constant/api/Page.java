package com.qiqiim.constant.api;
/**
 * 封装 PageHelper 的  page 类信息。  由于PageHelper的page 信息太多了。这里简化一下
 * @author  leihua
 * @date [2016年4月24日 上午11:13:24]
 * @version   1.0
 */
public class Page {
	/**
	 * 当前页
	 */
	private int pageNum;
	
	/**
	 * 总页数
	 */
	private int pages;
	
	/**
	 * 第一页
	 */
	private int firstPage;
	
	/**
	 * 上一页
	 */
	private int prePage;
	
	/**
	 * 下一页
	 */
	private int nextPage;
	
	/**
	 * 当前页的数量
	 */
    private int size;	
    
    /**
     * 总记录数
     */
    private long total;    
	
	/**
	 * 最后一页
	 */
	private int lastPage;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
