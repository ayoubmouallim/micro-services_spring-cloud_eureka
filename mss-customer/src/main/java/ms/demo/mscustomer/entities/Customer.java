package ms.demo.mscustomer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
}
