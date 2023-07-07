package com.assessment.project.customermanagementsystem.service;

import java.util.List;

import com.assessment.project.customermanagementsystem.dto.AddressDTO;

public interface AddressService {


    List<AddressDTO> getAddressByCustomerID(Long customerId);


    AddressDTO saveCustomerAdresses(Long customerId, AddressDTO addressDTO);


    List<AddressDTO> getAllAddresses();

    AddressDTO updateAddress(Long addressId, AddressDTO addressDTO);

}
