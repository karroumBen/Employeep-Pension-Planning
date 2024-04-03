package edu.miu.cs485.epps.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.miu.cs485.epps.Helper.LocalDateDeserializer;
import edu.miu.cs485.epps.Helper.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@JsonRootName("PensionPlan")
public class PensionPlan {
    @JsonProperty("planReferenceNumber")
    private String planReferenceNumber;
    @JsonProperty("enrollmentDate")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate enrollmentDate;
    @JsonProperty("monthlyContribution")
    private double monthlyContribution;
}
