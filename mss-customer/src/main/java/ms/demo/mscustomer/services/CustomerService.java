package ms.demo.mscustomer.services;

import ms.demo.mscustomer.dto.CustomerRequestDTO;
import ms.demo.mscustomer.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;


public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> getCustomers();
}
