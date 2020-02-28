package com.foreknow.util;




import java.util.List;

import com.foreknow.mapping.EntityMapping;


/**
 * 1.计算总记录数
 * 2.计算总页数
 * 3.查询某一个区间段的记录
 * @author Administrator
 *
 */
public interface Pagination {
    //判断当前所分的页是否为第一页
    public boolean isFirst();
    //判断当前所分的页是否为最后一页
    public boolean isLast();
    //判断是否还有下一页
    public boolean hasNext();
    //判断是否还有上一页
    public boolean hasPrevious();
    //返回当前要分页的总记录数
    public int getMaxElements();
    //返回总页数
    public int getMaxPages();
    //获得下一页的页码
    public int getNext();
    //返回上一页的页码
    public int getPrevious();
    //返回分页的大小，每页有多少条记录
    public int getPageSize();
    //返回当前页的页码
    public int getPageNumber();
    //返回当前页所包含的记录
    public List<Object> getList(EntityMapping mapping);
    //设定分页大小
    public void setPageSize(int pageSize);
    //设定当前要显示页面的页码
    public void setPageNumber(int pageNumber);

}
