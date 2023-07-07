package com.assessment.project.customermanagementsystem.util.mappers;

import com.assessment.project.customermanagementsystem.dto.AddressDTO;
import com.assessment.project.customermanagementsystem.entity.Address;
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
public class AddressMapperImpl implements AddressMapper {

    @Override
    public List<AddressDTO> entityListToDtoList(List<Address> address) {
        if ( address == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( address.size() );
        for ( Address address1 : address ) {
            list.add( entityToDto( address1 ) );
        }

        return list;
    }

    @Override
    public Address dtoToEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressId( addressDTO.getAddressId() );
        address.setAddressLine1( addressDTO.getAddressLine1() );
        address.setAddressLine2( addressDTO.getAddressLine2() );
        address.setCity( addressDTO.getCity() );
        address.setCountry( addressDTO.getCountry() );

        return address;
    }

    @Override
    public AddressDTO entityToDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setAddressId( address.getAddressId() );
        addressDTO.setAddressLine1( address.getAddressLine1() );
        addressDTO.setAddressLine2( address.getAddressLine2() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setCountry( address.getCountry() );

        return addressDTO;
    }
}
