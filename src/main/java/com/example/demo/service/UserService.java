package com.example.demo.service;

import com.example.demo.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 11:20 AM
 **/
public class UserService {
    @PersistenceContext
    EntityManager entityManager;


    public void save(Users users) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(users);
        transaction.commit();
        entityManager.close();

    }
}
