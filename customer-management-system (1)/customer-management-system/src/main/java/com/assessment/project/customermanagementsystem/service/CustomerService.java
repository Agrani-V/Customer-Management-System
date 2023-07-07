package com.assessment.project.customermanagementsystem.service;

import com.assessment.project.customermanagementsystem.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomer();

    CustomerDTO saveCustomer(CustomerDTO customerSaveDTO);

    CustomerDTO getCustomerById(Long customerId);

    List<CustomerDTO>  getCustomerFamilyById(Long customerId);

    CustomerDTO saveFamilyMember(Long customerId, CustomerDTO familyMemberDTO);

    CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO);


}
