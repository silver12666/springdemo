package com.akhambir.dao;

import com.akhambir.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    Category findById(Long cId);
}
