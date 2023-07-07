package com.assessment.project.customermanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {

    private Long addressId;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String country;
}
