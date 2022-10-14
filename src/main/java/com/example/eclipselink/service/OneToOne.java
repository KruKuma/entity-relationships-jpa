package com.example.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.eclipselink.entity.Department;
import com.example.eclipselink.entity.Employee;

public class OneToOne {

    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Create Department Entity
        Department department = new Department();
        department.setName("Department");

        // Store Department
        entityManager.persist(department);

        // Create Employee1 Entity
        Employee employee = new Employee();
        employee.setEname("Satish");
        employee.setSalary(45000.0);
        employee.setDeg("Technical Writer");
        employee.setDepartment(department);
        
        // Store Employees
        entityManager.persist(employee);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();

    }

}
