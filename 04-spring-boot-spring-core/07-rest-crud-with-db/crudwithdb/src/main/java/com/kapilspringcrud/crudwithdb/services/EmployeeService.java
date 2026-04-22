package com.kapilspringcrud.crudwithdb.services;

import com.kapilspringcrud.crudwithdb.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int empId);
    Employee create(Employee emp);
    void delete(int empId);
}
