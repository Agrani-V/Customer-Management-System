package com.assessment.project.customermanagementsystem.service;

import java.util.List;

import com.assessment.project.customermanagementsystem.dto.MobileNoDTO;

public interface MobileNumberService {

    List<MobileNoDTO> getAllMobileNos();

    MobileNoDTO updateMobileNo(Long mobileNoID, MobileNoDTO mobileNoDTO);

    List<MobileNoDTO> getCustomerMobileNosById(Long customerId);

    MobileNoDTO saveMobileNos(Long customerId, MobileNoDTO mobileNoDTO);
}
