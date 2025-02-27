package com.payroll.Services;

import com.payroll.DTO.EmployeeDTO;
import com.payroll.model.Employee;
import com.payroll.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
    // //UC-4 Introduce Service Layer with ResponseEntity
    // @Autowired
    // private EmployeeRepository employeeRepository;
    

    // public ResponseEntity<Employee> savEmployee(EmployeeDTO employeeDTO){
    //     Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
    //     Employee savedEmployee = employeeRepository.save(employee);
    //     return ResponseEntity.ok(savedEmployee);
    // }

    // public ResponseEntity<List<Employee>> getAllEmployees(){
    //     List<Employee> employees = employeeRepository.findAll();
    //     return ResponseEntity.ok(employees);
    // }

    // public ResponseEntity<Employee> getEmployeeById(Long id){
    //     Employee employee = employeeRepository.findById(id)
    //         .orElseThrow(() -> new RuntimeException("Employee not found with the id: " + id));
    //     return ResponseEntity.ok(employee);
    // }

    // public ResponseEntity<Employee> updateEmployee(Long id, EmployeeDTO updatetEmployee){
    //     Employee employee = employeeRepository.findById(id)
    //         .orElseThrow(() -> new RuntimeException("Employee not found with the id: " + id));
    //     employee.setName(updatetEmployee.getName());
    //     employee.setSalary(updatetEmployee.getSalary());
    //     Employee updated = employeeRepository.save(employee);
    //     return ResponseEntity.ok(updated);
    // }

    // public ResponseEntity<String> deleteEmployee(Long id){
    //     employeeRepository.deleteById(id);
    //     return ResponseEntity.ok("Employee deleted with ID: " + id);
    // }

    //UC-5 Store Employee Payroll Data in Memory (Using a List in Service Layer)
    private final List<Employee> employeeList  = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ResponseEntity<Employee> savEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(idCounter.getAndIncrement(), employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(employee);
        return ResponseEntity.ok(employee);
    }
    
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeList);
    }

    public ResponseEntity<Employee> getEmployeeById(Long id){
        Optional<Employee> employee  = employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
        return employee.map(ResponseEntity :: ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Employee>  updateEmployee(Long id,EmployeeDTO updateEmployee){
        for(Employee employee : employeeList){
            if(employee.getId().equals(id)){
                employee.setName(updateEmployee.getName());
                employee.setSalary(updateEmployee.getSalary());
                return ResponseEntity.ok(employee);
            }
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> deleteEmployee(Long id){
        boolean removed = employeeList.removeIf(employee -> employee.getId().equals(id));
        if(removed){
            return ResponseEntity.ok("Employee deleted with ID: " + id);
            
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
