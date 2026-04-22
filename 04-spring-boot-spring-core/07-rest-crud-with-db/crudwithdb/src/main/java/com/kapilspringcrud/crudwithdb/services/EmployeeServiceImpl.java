package com.kapilspringcrud.crudwithdb.services;

import com.kapilspringcrud.crudwithdb.dao.EmployeeDAO;
import com.kapilspringcrud.crudwithdb.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO theEmployeeDAO;

    public EmployeeServiceImpl(EmployeeDAO empDAO){
        theEmployeeDAO  = empDAO;
    }
    @Override
    public List<Employee> findAll() {
        return theEmployeeDAO.findAll();
    }

    @Override
    public Employee findById(int empId) {
        return theEmployeeDAO.findById(empId);
    }

    @Transactional
    @Override
    public Employee create(Employee emp) {
        return theEmployeeDAO.create(emp);
    }

    @Transactional
    @Override
    public String delete(int empId) {

        Employee emp = theEmployeeDAO.findById(empId);
        if (emp == null) {
            throw new RuntimeException("Employee with id " + empId + " Not found");
        }
        theEmployeeDAO.delete(empId);
        return "EmpId " + empId + " is deleted";
    }
}
