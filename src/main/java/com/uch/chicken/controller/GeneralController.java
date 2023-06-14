package com.uch.chicken.controller;

import com.uch.chicken.entity.Category;
import com.uch.chicken.service.CategoryService;
import com.uch.chicken.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "v1.0/general")
public class GeneralController {
    @Resource
    private ClientService clientService;

    @Resource
    private CategoryService categoryService;

    @PostMapping("/saveCategory")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }
}
