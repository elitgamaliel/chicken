package com.uch.chicken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uch.chicken.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // asda
}
