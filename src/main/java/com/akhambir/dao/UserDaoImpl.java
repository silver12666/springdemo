package com.akhambir.dao;

import com.akhambir.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }

    public User findById(Long id) {
        String query = "select u from  User as u " +
                "inner join ProductOrder as o " +
                "on u.id = o.id " +
                "where u.id =:id";
        User user = (User) sessionFactory
                .getCurrentSession()
                .createQuery(query)
                .setParameter("id", id)
                .uniqueResult();
        return user;
    }

    public User findByToken(String token) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User u where u.activationToken =:token")
                .setParameter("token", token)
                .uniqueResult();
    }

    public User findByEmail(String email) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User u where u.email =:email")
                .setParameter("email", email)
                .uniqueResult();
    }
}
