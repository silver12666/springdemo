package com.akhambir.dao;

import com.akhambir.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Category")
                .list();
    }

    @Override
    public Category findById(Long cId) {
        return sessionFactory
                .getCurrentSession()
                .find(Category.class, cId);
    }
}
