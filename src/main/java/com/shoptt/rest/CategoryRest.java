package com.shoptt.rest;

import com.shoptt.entity.Category;
import com.shoptt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryRest {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/admin/addOrUpdateCategory")
    public void save(@RequestBody Category category){
        categoryRepository.save(category);
    }

    @GetMapping("/public/getcategoryByCateId")
    public List<Category> getcategoryByCateId(@RequestParam("id") Long cateId){
        return categoryRepository.getcategoryByCateId(cateId);
    }

    @GetMapping("/public/allcategory")
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @GetMapping("/public/categoryByParentId")
    public List<Category> categoryByParentId(Long id){
        return categoryRepository.findByParentId(id);
    }

    @GetMapping("/public/categoryById")
    public Category findById(@RequestParam("id") Long id){
        return categoryRepository.findById(id).get();
    }

    @DeleteMapping("/admin/deleteCategory")
    public void deleteCategory(@RequestParam("id") Long id){
        categoryRepository.deleteById(id);
    }


}
