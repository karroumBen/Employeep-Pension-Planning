package edu.miu.cs485.epps.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@JsonRootName(value = "Employees")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

}
