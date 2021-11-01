package ms.demo.mscustomer.mappers;

import ms.demo.mscustomer.dto.CustomerRequestDTO;
import ms.demo.mscustomer.dto.CustomerResponseDTO;
import ms.demo.mscustomer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);

}
