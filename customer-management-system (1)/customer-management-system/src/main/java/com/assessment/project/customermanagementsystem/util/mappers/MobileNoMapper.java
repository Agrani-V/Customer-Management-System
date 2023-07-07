package com.assessment.project.customermanagementsystem.util.mappers;


import com.assessment.project.customermanagementsystem.dto.MobileNoDTO;
import com.assessment.project.customermanagementsystem.entity.MobileNumber;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MobileNoMapper {

    List<MobileNoDTO> entityListToDtoList(List<MobileNumber> mobileNumbr);

    MobileNumber dtoToEntity(MobileNoDTO mobileNumberDTO);

    MobileNoDTO entityToDto(MobileNumber mobileNumber);

}
