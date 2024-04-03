package edu.miu.cs485.epps.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.miu.cs485.epps.Helper.LocalDateDeserializer;
import edu.miu.cs485.epps.Helper.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    @JsonProperty("employeeId")
    private Long employeeId;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("employmentDate")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate employmentDate;

    @JsonProperty("yearlySalary")
    private double yearlySalary;

    @JsonProperty("pensionPlan")
    private PensionPlan pensionPlan;
}
