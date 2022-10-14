package com.example.eclipselink.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.eclipselink.entity.Department;
import com.example.eclipselink.entity.Employee;

public class OneToMany {

    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Create Employee1 Entity
        Employee employee1 = new Employee();
        employee1.setEname("Satish");
        employee1.setSalary(45000.0);
        employee1.setDeg("Technical Writer");

        // Create Employee2 Entity
        Employee employee2 = new Employee();
        employee2.setEname("Krisha");
        employee2.setSalary(45000.0);
        employee2.setDeg("Technical Writer");
        
        // Create Employee3 Entity
        Employee employee3 = new Employee();
        employee3.setEname("Masthanvali");
        employee3.setSalary(50000.0);
        employee3.setDeg("Technical Writer");
        
        // Store Employees
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        
        // Create EmployeeList
        List<Employee> empList = new ArrayList<>();
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        
        // Create Department Entity
        Department department = new Department();
        department.setName("Department");
        department.setEmployeeList(empList);

        // Store Department
        entityManager.persist(department);

        
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
        
    }

}
