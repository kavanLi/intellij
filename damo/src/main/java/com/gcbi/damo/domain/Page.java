package com.gcbi.damo.domain;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

    private int currentPageNum = 1;// 当前第几页(默认第一页),---主要用于传递到前台显示  
    private int totalPageNum;// 总页数  
    private int totalCount;// 总记录数  
    private int perPageSize = 5;// 每页显示的记录条数(默认5条)  
    private int startNum;

    public Page() {

    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    private List <T> entitys = new ArrayList <>();// 记录当前页中的数据条目

    // 所有参数都进行修改
    public Page(int currentPageNum, int totalCount, int perPageSize,
                List <T> entitys) {
        this.totalCount = totalCount;
        this.perPageSize = perPageSize;
        this.totalPageNum = totalCount % perPageSize == 0 ? totalCount
                / perPageSize : totalCount / perPageSize + 1;
        this.entitys = entitys;
        this.currentPageNum = currentPageNum < 1 ? 1 : (currentPageNum > totalPageNum ? totalPageNum : currentPageNum);//如果当前页小于第一页，则停留在第一页
    }

    public Page(int currentPageNum, int totalCount, int perPageSize) {
        this.totalCount = totalCount;
        this.perPageSize = perPageSize;
        this.totalPageNum = totalCount % perPageSize == 0 ? totalCount
                / perPageSize : totalCount / perPageSize + 1;
        this.currentPageNum = currentPageNum < 1 ? 1 : (currentPageNum > totalPageNum ? totalPageNum : currentPageNum);//如果当前页小于第一页，则停留在第一页
        this.startNum = (this.currentPageNum - 1) * (this.perPageSize);
    }

    // 使用默认的当前页和每页显示记录条数  
    public Page(int totalCount, List <T> entitys) {
        this.totalCount = totalCount;
        this.totalPageNum = totalCount % perPageSize == 0 ? totalCount
                / perPageSize : totalCount / perPageSize + 1;
        this.entitys = entitys;
        this.currentPageNum = currentPageNum < 1 ? 1 : (currentPageNum > totalPageNum ? totalPageNum : currentPageNum);//如果当前页小于第一页，则停留在第一页
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum < 1 ? 1 : (currentPageNum > totalPageNum ? totalPageNum : currentPageNum);//如果当前页小于第一页，则停留在第一页
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalCount % perPageSize == 0 ? totalCount
                / perPageSize : totalCount / perPageSize + 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPerPageSize() {
        return perPageSize;
    }

    public void setPerPageSize(int perPageSize) {
        this.perPageSize = perPageSize;
    }

    public List <T> getEntitys() {
        return entitys;
    }

    public void setEntitys(List <T> entitys) {
        this.entitys = entitys;
    }

    @Override
    public String toString() {
        return "PageUtil [currentPageNum=" + currentPageNum + ", totalPageNum="
                + totalPageNum + ", totalCount=" + totalCount
                + ", perPageSize=" + perPageSize + ", entitys=" + entitys + "]";
    }

}  