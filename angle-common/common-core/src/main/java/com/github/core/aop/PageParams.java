package com.github.core.aop;

/**
 * @author dujf
 */
public class PageParams {
  /**
   * 当前页:默认值1
   */
  private int currentPage = 1;
  /**
   * 每页条数:默认值10
   */
  private int pageSize = 10;

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
}
