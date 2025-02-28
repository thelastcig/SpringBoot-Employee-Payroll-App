package com.payroll.DTO;
//UC-6 Use Lombok to Auto-Generate Getters and Setters for DTO
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private double salary;    
}
