package com.assessment.project.customermanagementsystem.service.impl;

import com.assessment.project.customermanagementsystem.dto.AddressDTO;
import com.assessment.project.customermanagementsystem.entity.Address;
import com.assessment.project.customermanagementsystem.entity.Customer;
import com.assessment.project.customermanagementsystem.repo.AddressRepo;
import com.assessment.project.customermanagementsystem.repo.CustomerRepo;
import com.assessment.project.customermanagementsystem.service.AddressService;
import com.assessment.project.customermanagementsystem.util.mappers.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private CustomerRepo customerRepo;    

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public List<AddressDTO> getAddressByCustomerID(Long customerId) {
        if (customerRepo.existsById(customerId)){
            Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
            Customer customer = optionalCustomer.orElse(null);  

            List<Address> addressList = customer.getAddresses();

            if (addressList.size()>0){
                List<AddressDTO> addressDTOS = addressMapper.entityListToDtoList(addressList);
                return addressDTOS;
            }
        }
        return null;

    }


    @Override
    public AddressDTO saveCustomerAdresses(Long customerId, AddressDTO addressDTO) {

        Address address = addressMapper.dtoToEntity(addressDTO);
        if (customerRepo.existsById(customerId)){
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
            Customer customer = optionalCustomer.orElse(null);
            address.setCustomer(customer);

            Address savedAddress = addressRepo.save(address);
            AddressDTO savedAddressDTO = addressMapper.entityToDto(savedAddress);
            return savedAddressDTO;
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Customer already exists with the provided NIC");
            
        }   catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }     
    }
        throw new RuntimeException("No customer found!");

    }


    @Override
    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepo.findAll();
        if (addresses.size()>0){
            List<AddressDTO> addressDTOList = addressMapper.entityListToDtoList(addresses);
            return addressDTOList;
        }
        return null;
    }

    @Override
    public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) {
        if (addressRepo.existsById(addressId)){
            Address address = addressRepo.getReferenceById(addressId);
                    address.setAddressLine1(addressDTO.getAddressLine1());
                    address.setAddressLine2(addressDTO.getAddressLine2());
                    address.setCity(addressDTO.getCity());
                    address.setCountry(addressDTO.getCountry());
            try {
                Address savedAddress= addressRepo.save(address);
                AddressDTO savedAddressDTO = addressMapper.entityToDto(savedAddress);
                return savedAddressDTO;
            }   catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }  
        }
        throw new RuntimeException("No Address Found!");
    }
}
