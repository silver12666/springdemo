package com.akhambir.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(generator = "PRODUCT_GEN")
    @SequenceGenerator(name = "PRODUCT_GEN", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    private Long id;
    private String productName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY_ID")
    private Category category;

}
