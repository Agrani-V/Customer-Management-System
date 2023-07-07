package com.assessment.project.customermanagementsystem.util.mappers;

import com.assessment.project.customermanagementsystem.dto.MobileNoDTO;
import com.assessment.project.customermanagementsystem.entity.MobileNumber;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-07T18:30:20+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class MobileNoMapperImpl implements MobileNoMapper {

    @Override
    public List<MobileNoDTO> entityListToDtoList(List<MobileNumber> mobileNumbr) {
        if ( mobileNumbr == null ) {
            return null;
        }

        List<MobileNoDTO> list = new ArrayList<MobileNoDTO>( mobileNumbr.size() );
        for ( MobileNumber mobileNumber : mobileNumbr ) {
            list.add( entityToDto( mobileNumber ) );
        }

        return list;
    }

    @Override
    public MobileNumber dtoToEntity(MobileNoDTO mobileNumberDTO) {
        if ( mobileNumberDTO == null ) {
            return null;
        }

        MobileNumber mobileNumber = new MobileNumber();

        mobileNumber.setMobileNoId( mobileNumberDTO.getMobileNoId() );
        mobileNumber.setMobileNumber( mobileNumberDTO.getMobileNumber() );

        return mobileNumber;
    }

    @Override
    public MobileNoDTO entityToDto(MobileNumber mobileNumber) {
        if ( mobileNumber == null ) {
            return null;
        }

        MobileNoDTO mobileNoDTO = new MobileNoDTO();

        mobileNoDTO.setMobileNoId( mobileNumber.getMobileNoId() );
        mobileNoDTO.setMobileNumber( mobileNumber.getMobileNumber() );

        return mobileNoDTO;
    }
}
