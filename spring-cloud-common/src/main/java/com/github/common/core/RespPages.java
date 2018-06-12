//package com.github.common.core;
//
//
//import org.springframework.data.domain.Page;
//
//import java.util.List;
//
//public class RespPages<T> {
//
//    private int total;
//    private int size;
//    private int pages;
//    private int current;
//    private List<T> records;
//    private boolean asc;
//
//
//    public RespPages(Page<T> page) {
//        this.total = page.getTotal();
//        this.size = page.getSize();
//        this.pages = page.getPages();
//        this.current = page.getCurrent();
//        this.records = page.getRecords();
//        this.asc = page.isAsc();
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public int getPages() {
//        return pages;
//    }
//
//    public void setPages(int pages) {
//        this.pages = pages;
//    }
//
//    public int getCurrent() {
//        return current;
//    }
//
//    public void setCurrent(int current) {
//        this.current = current;
//    }
//
//    public List<T> getRecords() {
//        return records;
//    }
//
//    public void setRecords(List<T> records) {
//        this.records = records;
//    }
//
//    public boolean isAsc() {
//        return asc;
//    }
//
//    public void setAsc(boolean asc) {
//        this.asc = asc;
//    }
//}
