package com.example.eclipselink.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.eclipselink.entity.Claz;
import com.example.eclipselink.entity.Teacher;

public class ManyToMany {

    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Create Claz Entity
        Claz claz1 = new Claz(0, "1st", null);
        Claz claz2 = new Claz(0, "1st", null);
        Claz claz3 = new Claz(0, "1st", null);
        
        // Store Claz
        entityManager.persist(claz1);
        entityManager.persist(claz2);
        entityManager.persist(claz3);
        
        // Create Claz Set1
        Set<Claz> classSet1 = new HashSet<>();
        classSet1.add(claz1);
        classSet1.add(claz2);
        classSet1.add(claz3);
        
        // Create Claz Set2
        Set<Claz> classSet2 = new HashSet<>();
        classSet2.add(claz3);
        classSet2.add(claz1);
        classSet2.add(claz2);
        
        // Create Claz Set1
        Set<Claz> classSet3 = new HashSet<>();
        classSet3.add(claz2);
        classSet3.add(claz3);
        classSet3.add(claz1);
        
        // Create Teacher Entity
        Teacher teacher1 = new Teacher(0, "Satish", "Java", classSet1);
        Teacher teacher2 = new Teacher(0, "Krishna", "Adv Java", classSet2);
        Teacher teacher3 = new Teacher(0, "Masthanvali", "DB2", classSet3);
        
        // Store Teacher
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();

    }

}
