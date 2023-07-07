package com.assessment.project.customermanagementsystem.util.mappers;

import com.assessment.project.customermanagementsystem.dto.AddressDTO;
import com.assessment.project.customermanagementsystem.entity.Address;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    List<AddressDTO> entityListToDtoList(List<Address> address);

    Address dtoToEntity(AddressDTO addressDTO);

    AddressDTO entityToDto(Address address);
}
