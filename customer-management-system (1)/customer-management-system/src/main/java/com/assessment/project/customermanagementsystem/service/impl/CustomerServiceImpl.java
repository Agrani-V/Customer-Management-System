package com.assessment.project.customermanagementsystem.service.impl;

import com.assessment.project.customermanagementsystem.dto.CustomerDTO;
import com.assessment.project.customermanagementsystem.entity.Customer;
import com.assessment.project.customermanagementsystem.repo.CustomerRepo;
import com.assessment.project.customermanagementsystem.service.CustomerService;
import com.assessment.project.customermanagementsystem.util.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepo.findAll();
        if (customers.size()>0){
            List<CustomerDTO> customerDTOList = customerMapper.entityListToDtoList(customers);
            return customerDTOList;
        }
        return null;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) { 
        Customer customer = customerMapper.dtoToEntity(customerDTO);
        try {
            Customer savedCustomer = customerRepo.save(customer);
            CustomerDTO savedUserDTO = customerMapper.entityToDto(savedCustomer);
            return savedUserDTO;
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Customer already exists with the provided NIC");
        }   catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }     
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {

        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = customerMapper.entityToDto(customer);
            return customerDTO;
        }
        return null;
    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setDateOfBirth(customerDTO.getDateOfBirth());
            customer.setCustomerNIC(customerDTO.getCustomerNIC());
            try {
                Customer savedCustomer = customerRepo.save(customer);
                CustomerDTO savedUserDTO = customerMapper.entityToDto(savedCustomer);
                return savedUserDTO;
            } catch (DataIntegrityViolationException e) {
                throw new RuntimeException("Customer already exists with the provided NIC");
            }   catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }  
        }
        throw new RuntimeException("No customer Found!");
    }    

    @Override
    public List<CustomerDTO> getCustomerFamilyById(Long customerId) {

        if (customerRepo.existsById(customerId)){
            Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
            Customer customer = optionalCustomer.orElse(null);

            List<Customer> familyMemberList=customer.getFamilyMembers();
        
            List<CustomerDTO> familyMemberDTOList = customerMapper.entityListToDtoList(familyMemberList);
            return familyMemberDTOList;
        }
        return null;
    }    

    @Override
    public CustomerDTO saveFamilyMember(Long customerId, CustomerDTO familyMemberDTO) {
        Customer familyMember = customerMapper.dtoToEntity(familyMemberDTO);
        if (customerRepo.existsById(customerId)){
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
            Customer customer = optionalCustomer.orElse(null);
            familyMember.setFamilyMember(customer);

            Customer savedCustomer = customerRepo.save(familyMember);
            CustomerDTO savedUserDTO = customerMapper.entityToDto(savedCustomer);
            return savedUserDTO;
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Customer already exists with the provided NIC");
            
        }   catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }     
    }
        throw new RuntimeException("No customer found!");
    }    











}
