package com.assessment.project.customermanagementsystem.util.mappers;

import com.assessment.project.customermanagementsystem.dto.CustomerDTO;
import com.assessment.project.customermanagementsystem.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    List<CustomerDTO> entityListToDtoList(List<Customer> customers);

    Customer dtoToEntity(CustomerDTO customerSaveDTO);

    CustomerDTO entityToDto(Customer customer);
}
