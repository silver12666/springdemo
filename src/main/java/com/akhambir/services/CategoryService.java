package com.akhambir.services;

import com.akhambir.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long cId);
}
