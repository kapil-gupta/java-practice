package com.kapilspringcrud.crudwithdb.dao;

import com.kapilspringcrud.crudwithdb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
