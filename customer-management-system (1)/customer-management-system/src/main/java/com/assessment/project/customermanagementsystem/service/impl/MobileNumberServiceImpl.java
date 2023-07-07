package com.assessment.project.customermanagementsystem.service.impl;


import com.assessment.project.customermanagementsystem.dto.AddressDTO;
import com.assessment.project.customermanagementsystem.dto.MobileNoDTO;
import com.assessment.project.customermanagementsystem.entity.Address;
import com.assessment.project.customermanagementsystem.entity.Customer;
import com.assessment.project.customermanagementsystem.entity.MobileNumber;
import com.assessment.project.customermanagementsystem.repo.CustomerRepo;
import com.assessment.project.customermanagementsystem.repo.MobileNumberRepo;
import com.assessment.project.customermanagementsystem.service.MobileNumberService;

import com.assessment.project.customermanagementsystem.util.mappers.MobileNoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileNumberServiceImpl implements MobileNumberService {

    @Autowired
    private MobileNumberRepo mobileNumberRepo;

    @Autowired
    private MobileNoMapper mobileNoMapper;

    @Autowired
    private CustomerRepo customerRepo; 

    @Override
    public List<MobileNoDTO> getAllMobileNos() {
        List<MobileNumber> mobileNos = mobileNumberRepo.findAll();
        if (mobileNos.size()>0){
            List<MobileNoDTO> mobileNoDTOList = mobileNoMapper.entityListToDtoList(mobileNos);
            return mobileNoDTOList;
        }
        return null;
    }

    @Override
    public MobileNoDTO updateMobileNo(Long mobileNoID, MobileNoDTO mobileNoDTO) {
        if (mobileNumberRepo.existsById(mobileNoID)){
            MobileNumber mobileNo = mobileNumberRepo.getReferenceById(mobileNoID);
                    mobileNo.setMobileNumber(mobileNoDTO.getMobileNumber());
            try {
                MobileNumber savedMobileNumber= mobileNumberRepo.save(mobileNo);
                MobileNoDTO savedMobileNumberDTO = mobileNoMapper.entityToDto(savedMobileNumber);
                return savedMobileNumberDTO;
            }   catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }  
        }
        throw new RuntimeException("No MobieNo Found!");
    }

    @Override
    public List<MobileNoDTO> getCustomerMobileNosById(Long customerId) {
        if (customerRepo.existsById(customerId)){
            Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
            Customer customer = optionalCustomer.orElse(null);  

            List<MobileNumber> mobileNumberList = customer.getMobileNumbers();

            if (mobileNumberList.size()>0){
                List<MobileNoDTO> mobileNoDTOS = mobileNoMapper.entityListToDtoList(mobileNumberList);
                return mobileNoDTOS;
            }
        }
        return null;
    }

    @Override
    public MobileNoDTO saveMobileNos(Long customerId, MobileNoDTO mobileNoDTO) {
        MobileNumber mobileNumber = mobileNoMapper.dtoToEntity(mobileNoDTO);
        if (customerRepo.existsById(customerId)){
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
            Customer customer = optionalCustomer.orElse(null);
            mobileNumber.setCustomer(customer);

            MobileNumber savedMobileNumber = mobileNumberRepo.save(mobileNumber);
            MobileNoDTO savedMobileNoDTO = mobileNoMapper.entityToDto(savedMobileNumber);
            return savedMobileNoDTO;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }     
    }
        throw new RuntimeException("No customer found!");
    }


}
