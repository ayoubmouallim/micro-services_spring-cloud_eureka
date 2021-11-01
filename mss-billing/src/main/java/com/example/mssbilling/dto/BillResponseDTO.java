package com.example.mssbilling.dto;

import com.example.mssbilling.entities.ProductItem;
import com.example.mssbilling.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillResponseDTO {

    private String id;
    private Date billingDate;
    private Double amount;
    private Collection<ProductItemResponseDTO> productItems;
    private Customer customer;


}
