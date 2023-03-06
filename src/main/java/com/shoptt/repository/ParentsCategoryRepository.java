package com.shoptt.repository;

import com.shoptt.entity.Invoice;
import com.shoptt.entity.ParentsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentsCategoryRepository extends JpaRepository<ParentsCategory, Long> {
}
