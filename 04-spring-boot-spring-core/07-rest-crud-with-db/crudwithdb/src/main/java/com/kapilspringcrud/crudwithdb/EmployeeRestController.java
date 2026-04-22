package com.kapilspringcrud.crudwithdb;

import com.kapilspringcrud.crudwithdb.dao.EmployeeDAO;
import com.kapilspringcrud.crudwithdb.entity.Employee;
import com.kapilspringcrud.crudwithdb.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService theEmpService;
    private final JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService empService, JsonMapper jsonMapper1){

        theEmpService = empService;
        this.jsonMapper = jsonMapper1;
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

    @PatchMapping("/employees/{empId}")
    public Employee updateEmployeePartially(@PathVariable int empId,@RequestBody Map<String,Object> patchedData ){
        Employee tempEmp = theEmpService.findById(empId);
        if(tempEmp == null){
            throw new RuntimeException("Employee Not Found with Id "+empId);
        }
        if(patchedData.containsKey("id")){
            throw new RuntimeException("Employee path data can't contain id key");
        }
        Employee empUpdatedData = jsonMapper.updateValue(tempEmp, patchedData);
        return theEmpService.create(empUpdatedData);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteById(@PathVariable int empId){
        theEmpService.delete(empId);
    }

}
