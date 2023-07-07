package com.assessment.project.customermanagementsystem.controller;

import com.assessment.project.customermanagementsystem.dto.AddressDTO;
import com.assessment.project.customermanagementsystem.dto.CustomerDTO;
import com.assessment.project.customermanagementsystem.dto.MobileNoDTO;
import com.assessment.project.customermanagementsystem.service.AddressService;
import com.assessment.project.customermanagementsystem.service.CustomerService;
import com.assessment.project.customermanagementsystem.service.MobileNumberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private MobileNumberService mobileNumberService;

    @GetMapping
    private ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customerDTOList = customerService.getAllCustomer();
        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }
 

    @PostMapping
    private ResponseEntity<CustomerDTO>  saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customer = customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    private ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(value = "id") Long customerId){
        CustomerDTO customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }    

    @PutMapping("{id}")
    private ResponseEntity<CustomerDTO> updateCustomer(@PathVariable(value = "id") Long customerId,@RequestBody CustomerDTO customerDTO){
        CustomerDTO customer  = customerService.updateCustomer(customerId, customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }        

    @GetMapping("{id}/family")
    private ResponseEntity<List<CustomerDTO>> getCustomerFamilyById(@PathVariable(value = "id") Long customerId){
        List<CustomerDTO> customerDTOList = customerService.getCustomerFamilyById(customerId);
        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }    

    @PostMapping("{id}/family")
    private ResponseEntity<CustomerDTO>  saveFamilyMember(@PathVariable(value = "id") Long customerId, @RequestBody CustomerDTO familyMemberDTO){
        CustomerDTO familyMember = customerService.saveFamilyMember(customerId, familyMemberDTO);
        return new ResponseEntity<>(familyMember, HttpStatus.CREATED);
    }

    @GetMapping("{id}/address")
    private ResponseEntity<List<AddressDTO>> getCustomerAdressesById(@PathVariable(value = "id") Long customerId){
        List<AddressDTO> addressDTOList = addressService.getAddressByCustomerID(customerId);
        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
       
    }        

    @PostMapping("{id}/address")
    private ResponseEntity<AddressDTO>  saveCustomerAdresses(@PathVariable(value = "id") Long customerId, @RequestBody AddressDTO addressDTO){
        AddressDTO address = addressService.saveCustomerAdresses(customerId, addressDTO);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }    

    @GetMapping("{id}/mobileNo")
    private ResponseEntity<List<MobileNoDTO>> getCustomerMobileNosById(@PathVariable(value = "id") Long customerId){
        List<MobileNoDTO> mobileNoDTOList = mobileNumberService.getCustomerMobileNosById(customerId);
        return new ResponseEntity<>(mobileNoDTOList, HttpStatus.OK);
       
    }        

    @PostMapping("{id}/mobileNo")
    private ResponseEntity<MobileNoDTO>  saveCustomerMobileNos(@PathVariable(value = "id") Long customerId, @RequestBody MobileNoDTO mobileNoDTO){
        MobileNoDTO mobileNo = mobileNumberService.saveMobileNos(customerId, mobileNoDTO);
        return new ResponseEntity<>(mobileNo, HttpStatus.CREATED);
    }        

}
