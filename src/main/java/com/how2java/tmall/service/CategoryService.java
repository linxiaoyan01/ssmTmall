package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;

import java.util.List;

/**
 * @author Yuery
 * @date 2020/7/7/0007 - 17:13
 */
public interface CategoryService {

    List<Category> list();
    void delete(int id);

    void add(Category category);
    Category get(int id);
    void update(Category category);
}
