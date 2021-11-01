package com.example.mssbilling.entities;

import com.example.mssbilling.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    private String id;
    private Date billingDate;
    private Double amount;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private String customerId;
    @Transient
    private Customer customer;

}
