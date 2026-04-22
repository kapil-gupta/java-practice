package com.kapilspringcrud.crudwithdb;

import com.kapilspringcrud.crudwithdb.dao.EmployeeDAO;
import com.kapilspringcrud.crudwithdb.entity.Employee;
import com.kapilspringcrud.crudwithdb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService theEmpService;
    public EmployeeRestController(EmployeeService empService){
        theEmpService = empService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return theEmpService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findById(@PathVariable int empId){
        return theEmpService.findById(empId);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return theEmpService.create(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmp){
        return theEmpService.create(theEmp);
    }
    @DeleteMapping("/employees/{empId}")
    public void deleteById(@PathVariable int empId){
        theEmpService.delete(empId);
    }

}
