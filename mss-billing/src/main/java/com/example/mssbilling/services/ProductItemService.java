package com.example.mssbilling.services;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;
import com.example.mssbilling.dto.ProductItemRequestDTO;
import com.example.mssbilling.dto.ProductItemResponseDTO;

import java.util.List;

public interface ProductItemService {
    ProductItemResponseDTO save(ProductItemRequestDTO productItemRequestDTO);


}
