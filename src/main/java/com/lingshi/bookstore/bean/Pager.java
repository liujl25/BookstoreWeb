package com.lingshi.bookstore.bean;

import java.util.List;

/**
 * @description: 使用泛型编程，实现带条件的分页查询
 *
 * @auther: 暴走D红领巾
 * @date: 2018/6/16 22:18
 */
public class Pager<T> {
    private int currentPage = 1;//第几页-默认是第一页，不能小于1
    private int pageSize = 8;//每页查几条-默认值是10条，不能小于1
    private int total;//要分页的记录总数

    private T param;//使用泛型传递查询条件
    private List<T> results;//使用泛型接受查询接口

    public Pager() {
    }

    public Pager(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    /**
     * 开始查询的索引，即从第几条开始查
     * @return
     */
    public int getStartIndex(){
        return (currentPage-1)*pageSize;
    }
    /**
     * 计算总页数
     * @return
     */
    public int getTotal(){
        return total;
    }
    /**
     * 获取总页数
     * @return
     */
    public int getPages(){
        //可以分成整页的取商；不能的需要商+1页
        int pages = total%pageSize==0?total/pageSize:total/pageSize+1;
        return pages;
    }
    public int getPrePage(){//上一页
        //当前页是第一页，不能往前翻，否则翻一页
        int prePage = currentPage==1?1:currentPage-1;
        return prePage;
    }
    public int getNextPage(){//下一页
        int nextPage = currentPage==getPages()?getPages():currentPage+1;
        return nextPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage >= 1)
            this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize >= 1)
        this.pageSize = pageSize;
    }
    //总记录数
    public void setTotal(int total) {
        if(total >= 0)
            this.total = total;
    }

    public T getParam() {
        return param;

    }

    public void setParam(T param) {
        this.param = param;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
