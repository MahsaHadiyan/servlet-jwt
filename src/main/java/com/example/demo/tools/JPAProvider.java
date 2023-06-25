package com.example.demo.tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAProvider {

    private JPAProvider(){
        System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    }
    private static final EntityManagerFactory FACTORY  = Persistence.createEntityManagerFactory("J2OS");

    public static EntityManager getEntityManager() {
        System.out.println("22222222222222222222222222222222222222");
        return FACTORY.createEntityManager();
    }
}
