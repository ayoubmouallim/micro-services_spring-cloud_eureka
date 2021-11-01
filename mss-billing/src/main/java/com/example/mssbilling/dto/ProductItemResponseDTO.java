package com.example.mssbilling.dto;

import com.example.mssbilling.entities.Bill;
import com.example.mssbilling.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemResponseDTO {

    private String id;
    private  double qte;
    private double price;
    private Product product;
    private Bill bill;

}
