package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Review;

import java.util.List;

/**
 * @author Yuery
 * @date 2020/7/16/0016 - 21:10
 */
public interface ReviewService {
    //CRUD
    void add(Review c);

    void delete(int id);

    void update(Review c);

    Review get(int id);

    //通过产品获取评价的方法

    List list(int pid);

    int getCount(int pid);
}
