package com.uch.chicken.service;

import com.uch.chicken.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    Category update(Category category);

    void delete(Integer idCategory);

    List<Category> findAll();

    Category findById(Integer idCategory);
}
