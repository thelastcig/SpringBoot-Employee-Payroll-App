package com.payroll.Services;

import com.payroll.DTO.EmployeeDTO;
import com.payroll.model.Employee;
import com.payroll.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee savEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }


    
}
