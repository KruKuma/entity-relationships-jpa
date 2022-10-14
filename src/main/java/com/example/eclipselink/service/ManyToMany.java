package com.example.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.eclipselink.entity.Department;
import com.example.eclipselink.entity.Employee;

public class ManyToMany {

    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        
        
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();

    }

}
