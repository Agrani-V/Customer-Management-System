package com.assessment.project.customermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private Long customerId;
    
    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String customerNIC;

}
