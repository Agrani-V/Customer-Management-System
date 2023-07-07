package com.assessment.project.customermanagementsystem.controller;

import com.assessment.project.customermanagementsystem.dto.AddressDTO;
import com.assessment.project.customermanagementsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    private ResponseEntity<List<AddressDTO>> getAllAddresses(){
        List<AddressDTO> addressDTOList = addressService.getAllAddresses();
        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    private ResponseEntity<AddressDTO> updateAddress(@PathVariable(value = "id") Long addressId,@RequestBody AddressDTO addressDTO){
        AddressDTO address  = addressService.updateAddress(addressId, addressDTO);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }        
}
