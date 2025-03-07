package com.payroll.DTO;
//UC-6 Use Lombok to Auto-Generate Getters and Setters for DTO
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Data
@NoArgsConstructor
public class EmployeeDTO {
    //UC-10 Add Validation to the Name Field in Employee DTO
    @NotBlank(message = "Name is required and cannot be empty.")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;
    private double salary;    
}
