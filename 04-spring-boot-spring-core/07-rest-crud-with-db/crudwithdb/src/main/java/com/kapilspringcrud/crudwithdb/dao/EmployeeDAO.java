package com.kapilspringcrud.crudwithdb.dao;

import com.kapilspringcrud.crudwithdb.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int empId);
    Employee create(Employee emp);
    void delete(int empId);
}
