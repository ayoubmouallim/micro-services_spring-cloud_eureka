package ms.demo.mscustomer;

import ms.demo.mscustomer.dto.CustomerRequestDTO;
import ms.demo.mscustomer.entities.Customer;
import ms.demo.mscustomer.repository.CustomerRepository;
import ms.demo.mscustomer.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MsCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomerApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerService customerService )
    {

        return args->{
           customerService.save(new CustomerRequestDTO("C01","kamal","kamal@gmail.com"));
            customerService.save(new CustomerRequestDTO("C02","salim","salim@gmail.com"));
            customerService.save(new CustomerRequestDTO("C03","youssef","youssef@gmail.com"));

            customerService.getCustomers().forEach(customer -> System.out.println(customer.getName()));
        };
    }

}
