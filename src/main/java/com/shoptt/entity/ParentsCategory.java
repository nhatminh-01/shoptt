package com.shoptt.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ParentsCategory")
@Getter
@Setter
public class ParentsCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ParentsCategory_SEQ")
    @SequenceGenerator(name="ParentsCategory_SEQ", sequenceName="ParentsCategory_SEQ", allocationSize=1)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parentsCategory", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Category> categories;

}
