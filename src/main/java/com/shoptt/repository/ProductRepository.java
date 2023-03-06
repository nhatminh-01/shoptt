package com.shoptt.repository;

import com.shoptt.entity.AddressUser;
import com.shoptt.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where deleted = 0 order by id desc", nativeQuery = true)
    public List<Product> findAllDesc();

    @Query(value = "select p from Product p where p.deleted = 0 and p.category.id = ?1")
    public List<Product> findByCategoryId(Long categoryId);

    @Query(value = "select p from Product p where p.deleted = 0")
    public Page<Product> findNewIndexPage(Pageable pageable);

    @Query(value = "select * from PRODUCT where CATEGORY_ID = ?1 and id != ?2 and deleted = 0 OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY", nativeQuery = true)
    public List<Product> getSanPhamCungDanhMuc(Long cateId, Long proId);

    @Query(value = "select p from Product p where p.deleted = 0 and p.price >= ?1 and p.price <= ?2 and p.category.id = ?3")
    public Page<Product> searchByPrice(Double price1, Double price2,Long cateId, Pageable pageable);

    @Query(value = "select p from Product p inner join p.category c where p.deleted = 0 and (p.name like ?1 or c.name like ?1) order by p.id desc ", nativeQuery = false)
    public Page<Product> search(String param, Pageable pageable);

    @Query("select sum(p.quantity) from Product p")
    Double tongSp();

    @Query(value = "select * from product where product.deleted = 0 order by (select sum(d.quantity) from detail_invoice d inner join product pr on pr.id = d.product_id where pr.id = product.id) desc", nativeQuery = true)
    public Page<Product> getSpBanChay(Pageable pageable);

    @Query("select p from Product p where p.id = ?1")
    public Product findByIds(Long id);
}
