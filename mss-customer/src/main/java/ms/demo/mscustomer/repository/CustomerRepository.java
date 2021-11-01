package ms.demo.mscustomer.repository;

import ms.demo.mscustomer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface CustomerRepository extends JpaRepository<Customer,String> {
}
