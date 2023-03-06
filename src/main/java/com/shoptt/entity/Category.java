package com.shoptt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Category_SEQ")
    @SequenceGenerator(name="Category_SEQ", sequenceName="Category_SEQ", allocationSize=1)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parentsCategory_id")
    @JsonBackReference
    private ParentsCategory parentsCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
