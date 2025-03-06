package com.payroll.controller;
import com.payroll.DTO.EmployeeDTO;
import com.payroll.Services.EmployeeService;
import com.payroll.model.Employee;
import com.payroll.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {
    // private final EmployeeService employeeService;
    // private final EmployeeRepository employeeRepository;

    // public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
    //     this.employeeRepository = employeeRepository;
    //     this.employeeService = employeeService;
    // }

    // //UC-1 Setup Employee Payroll App with REST and MySQL 

    // //curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Sonu Sharma\",\"salary\":2000}" http://localhost:8080/employeepayrollservice/create
    // @PostMapping("/create")
    // public Employee createEmployee(@RequestBody Employee employee) {
    //     return employeeRepository.save(employee);
    // }

    // //UC-2 Add REST endpoints for Employee CRUD operations  
    // //http://localhost:8080/employeepayrollservice/
    // @GetMapping("/")
    // public List<Employee> getAllEmployees() {
    //     return employeeRepository.findAll();
    // }

    // //http://localhost:8080/employeepayrollservice/get/2
    // @GetMapping("/get/{id}")
    // public Employee getEmployeeById(@PathVariable Long id) {
    //     return employeeRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    // }

    // //curl -X PUT -H "Content-Type: application/json" -d "{\"name\":\"Saurabh Sharma\",\"salary\":3000}" http://localhost:8080/employeepayrollservice/update/2
    // @PutMapping("/update/{id}")
    // public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
    //     Employee employee = employeeRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

    //     employee.setName(updatedEmployee.getName());
    //     employee.setSalary(updatedEmployee.getSalary());
    //     return employeeRepository.save(employee);
    // }
    // //curl -X DELETE http://localhost:8080/employeepayrollservice/delete/4
    // @DeleteMapping("/delete/{id}")
    // public String deleteEmployee(@PathVariable Long id) {
    //     employeeRepository.deleteById(id);
    //     return "Employee deleted with ID: " + id;
    // }

    // //UC-3 Introducing DTO and Model to Employee Payroll App
    // @PostMapping("/create-dto")
    // public ResponseEntity<Employee> createEmployeeWithDTO(@RequestBody EmployeeDTO employeeDTO){
    //     Employee savedEmployee = employeeService.savEmployee(employeeDTO);
    //     return ResponseEntity.ok(savedEmployee);
    // }

    //UC-4 Introduce Service Layer with ResponseEntity
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create-dto")
    public ResponseEntity<Employee> createEmployeeWithDTO(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.savEmployee(employeeDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return employeeService.getAllEmployees();
    } 
 
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
     

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
