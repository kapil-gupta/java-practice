package com.kapilspringcrud.crudwithdb.services;

import com.kapilspringcrud.crudwithdb.dao.EmployeeRepository;
import com.kapilspringcrud.crudwithdb.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository theEmployeeRepo;

    public EmployeeServiceImpl(EmployeeRepository empDAO) {
        theEmployeeRepo = empDAO;
    }

    @Override
    public List<Employee> findAll() {
        return theEmployeeRepo.findAll();
    }

    @Override
    public Employee findById(int empId) {

        Optional<Employee> tempEmp = theEmployeeRepo.findById(empId);
        Employee theEmp = null;
        if (tempEmp.isEmpty()) {
            throw new RuntimeException("Emp not found with Id " + empId);
        }
        theEmp = tempEmp.get();
        return theEmp;
    }

    @Transactional
    @Override
    public Employee create(Employee emp) {
        return theEmployeeRepo.save(emp);
    }

    @Transactional
    @Override
    public String delete(int empId) {
        Optional<Employee> tempEmp = theEmployeeRepo.findById(empId);
        Employee theEmp = null;
        if (tempEmp.isEmpty()) {
            throw new RuntimeException("Emp not found with Id " + empId);
        }
        theEmp = tempEmp.get();

        theEmployeeRepo.delete(theEmp);
        return "EmpId " + empId + " is deleted";
    }
}
