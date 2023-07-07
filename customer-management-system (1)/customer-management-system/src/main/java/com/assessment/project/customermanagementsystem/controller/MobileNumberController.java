package com.assessment.project.customermanagementsystem.controller;


import com.assessment.project.customermanagementsystem.dto.MobileNoDTO;
import com.assessment.project.customermanagementsystem.service.MobileNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/mobileNo")
public class MobileNumberController {

    @Autowired
    private MobileNumberService mobileNumberService;

    @GetMapping
    private ResponseEntity<List<MobileNoDTO>> getAllMobileNos(){
        List<MobileNoDTO> mobileNoDTOList = mobileNumberService.getAllMobileNos();
        return new ResponseEntity<>(mobileNoDTOList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    private ResponseEntity<MobileNoDTO> updateMobileNo(@PathVariable(value = "id") Long mobileNoID,@RequestBody MobileNoDTO mobileNoDTO){
        MobileNoDTO mobileNo  = mobileNumberService.updateMobileNo(mobileNoID, mobileNoDTO);
        return new ResponseEntity<>(mobileNo, HttpStatus.OK);
    }        
}
