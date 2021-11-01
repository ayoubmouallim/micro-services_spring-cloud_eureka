package ms.demo.mscustomer.web;

import ms.demo.mscustomer.dto.CustomerRequestDTO;
import ms.demo.mscustomer.dto.CustomerResponseDTO;
import ms.demo.mscustomer.entities.Customer;
import ms.demo.mscustomer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;




    @PostMapping("/customers/")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }


    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable("id")String id)
    {
        return customerService.getCustomer(id);
    }

    @PutMapping("/customers/")
    public CustomerResponseDTO updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.update(customerRequestDTO);
    }

    @GetMapping("customers")
    public List<CustomerResponseDTO> getCustomers()
    {
        return customerService.getCustomers();
    }


}
