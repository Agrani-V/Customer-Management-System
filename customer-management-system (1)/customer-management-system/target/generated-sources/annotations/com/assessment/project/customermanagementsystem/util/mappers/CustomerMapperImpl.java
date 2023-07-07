package com.assessment.project.customermanagementsystem.util.mappers;

import com.assessment.project.customermanagementsystem.dto.CustomerDTO;
import com.assessment.project.customermanagementsystem.entity.Customer;
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
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public List<CustomerDTO> entityListToDtoList(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( entityToDto( customer ) );
        }

        return list;
    }

    @Override
    public Customer dtoToEntity(CustomerDTO customerSaveDTO) {
        if ( customerSaveDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( customerSaveDTO.getCustomerId() );
        customer.setFirstName( customerSaveDTO.getFirstName() );
        customer.setLastName( customerSaveDTO.getLastName() );
        customer.setDateOfBirth( customerSaveDTO.getDateOfBirth() );
        customer.setCustomerNIC( customerSaveDTO.getCustomerNIC() );

        return customer;
    }

    @Override
    public CustomerDTO entityToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId( customer.getCustomerId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setDateOfBirth( customer.getDateOfBirth() );
        customerDTO.setCustomerNIC( customer.getCustomerNIC() );

        return customerDTO;
    }
}
