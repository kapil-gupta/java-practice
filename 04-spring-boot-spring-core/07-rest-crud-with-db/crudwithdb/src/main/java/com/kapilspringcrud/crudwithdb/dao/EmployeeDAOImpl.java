package com.kapilspringcrud.crudwithdb.dao;

import com.kapilspringcrud.crudwithdb.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager theEntityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        theEntityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = theEntityManager.createQuery("FROM Employee",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int empId) {
        // get employee

        // return employee
        return theEntityManager.find(Employee.class, empId);
    }

    @Override
    public Employee create(Employee emp) {
        // save employee

        // return the dbEmployee
        return theEntityManager.merge(emp);
    }



    @Override
    public void delete(int empId) {
        // find employee by id
        Employee theEmployee = theEntityManager.find(Employee.class, empId);

        // remove employee
        theEntityManager.remove(theEmployee);
    }
}
