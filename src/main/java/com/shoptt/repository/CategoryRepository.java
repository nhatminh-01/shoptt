package com.shoptt.repository;

import com.shoptt.entity.AddressUser;
import com.shoptt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.parentsCategory.id = ?1")
    public List<Category> findByParentId(Long id);

    @Query(value = "select c.* from CATEGORY c where c.PARENTS_CATEGORY_ID = (select PARENTS_CATEGORY_ID from CATEGORY where id = ?1)", nativeQuery = true)
    public List<Category> getcategoryByCateId(Long id);

}
