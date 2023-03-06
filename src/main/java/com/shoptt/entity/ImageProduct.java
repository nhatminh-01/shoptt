package com.shoptt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ImageProduct")
@Getter
@Setter
public class ImageProduct implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ImageProduct_SEQ")
    @SequenceGenerator(name="ImageProduct_SEQ", sequenceName="ImageProduct_SEQ", allocationSize=1)
    @Column(name = "id")
    private Long id;

    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
