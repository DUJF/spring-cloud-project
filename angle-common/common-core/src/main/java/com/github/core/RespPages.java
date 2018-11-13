package com.github.core;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * @author dujf
 */
public class RespPages<T> {

    private Long total;
    private Long size;
    private Long pages;
    private Long current;
    private List<T> records;
    private boolean asc;


    public RespPages(Page<T> page) {
        this.total = page.getTotal();
        this.size = page.getSize();
        this.pages = page.getPages();
      this.current = page.getCurrent();
        this.records = page.getRecords();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
