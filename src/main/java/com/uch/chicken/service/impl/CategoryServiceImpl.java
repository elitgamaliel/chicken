package com.uch.chicken.service.impl;

import com.uch.chicken.entity.Category;
import com.uch.chicken.repository.CategoryRepository;
import com.uch.chicken.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Integer idCategory) {
        categoryRepository.deleteById(idCategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer idCategory) {
        return categoryRepository.findById(idCategory).orElse(null);
    }
}
