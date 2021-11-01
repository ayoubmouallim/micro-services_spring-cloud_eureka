package ms.demo.mscustomer.services;

import ms.demo.mscustomer.dto.CustomerRequestDTO;
import ms.demo.mscustomer.dto.CustomerResponseDTO;
import ms.demo.mscustomer.entities.Customer;
import ms.demo.mscustomer.mappers.CustomerMapper;
import ms.demo.mscustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements  CustomerService{

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {


        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);

        Customer savedCustomer =customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customer);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {

        Customer customer= customerMapper.customerRequestDtoToCustomer(customerRequestDTO);

        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> getCustomers() {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOList = customers.stream()
            .map(customer -> customerMapper.customerToCustomerResponseDTO(customer))
            .collect(Collectors.toList());


        return customerResponseDTOList;
    }
}
