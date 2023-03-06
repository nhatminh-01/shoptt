package com.shoptt.repository;

import com.shoptt.entity.AddressUser;
import com.shoptt.entity.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageProductRepository extends JpaRepository<ImageProduct, Long> {

    @Query(value = "select * from IMAGE_PRODUCT i where PRODUCT_ID = ?1", nativeQuery = true)
    public List<ImageProduct> findByProductIds(Integer proId);
}
