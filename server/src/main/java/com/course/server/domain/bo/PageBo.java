package com.course.server.domain.bo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silas
 * Date: 2020/6/7
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class PageBo<T> {

    private  int page;

    private  int size;

    private  long total;

    private List<T> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
