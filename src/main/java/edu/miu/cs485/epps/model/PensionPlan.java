package edu.miu.cs485.epps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PensionPlan {
    private String planReferenceNumber;
    private String enrollmentDate;
    private double monthlyContribution;
}
