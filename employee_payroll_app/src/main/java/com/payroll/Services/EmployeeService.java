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
    @Autowired
    private EmployeeRepository employeeRepository;
    

    public ResponseEntity<Employee> savEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    public ResponseEntity<Employee> getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with the id: " + id));
        return ResponseEntity.ok(employee);
    }

    public ResponseEntity<Employee> updateEmployee(Long id, EmployeeDTO updatetEmployee){
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with the id: " + id));
        employee.setName(updatetEmployee.getName());
        employee.setSalary(updatetEmployee.getSalary());
        Employee updated = employeeRepository.save(employee);
        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<String> deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Employee deleted with ID: " + id);
    }

    
}
