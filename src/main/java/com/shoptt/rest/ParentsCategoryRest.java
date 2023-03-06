package com.shoptt.rest;

import com.shoptt.entity.ParentsCategory;
import com.shoptt.entity.Product;
import com.shoptt.repository.ParentsCategoryRepository;
import com.shoptt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ParentsCategoryRest {

    @Autowired
    private ParentsCategoryRepository parentsCategoryRepository;

    @GetMapping("/allParentsCategory")
    public List<ParentsCategory> findAll(){
        return parentsCategoryRepository.findAll();
    }
}
