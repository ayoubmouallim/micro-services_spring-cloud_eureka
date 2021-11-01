package com.example.mssbilling.dto;

import com.example.mssbilling.entities.ProductItem;
import com.example.mssbilling.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRequestDTO {

    private Collection<ProductItemRequestDTO> productItems;
    private String customerId;
    private Double amount;



}
