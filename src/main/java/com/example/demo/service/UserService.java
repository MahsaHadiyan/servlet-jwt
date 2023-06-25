package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.tools.JPAProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 11:20 AM
 **/
public class UserService {

    private static final UserService USER_SERVICE= new UserService();


    public static UserService getInstance(){
        return USER_SERVICE;
    }

    EntityManager entityManager;


    public void save(Users users) {
        entityManager= JPAProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(users);
        transaction.commit();
        entityManager.close();
    }
}
