package com.example.mssbilling.mappers;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;
import com.example.mssbilling.dto.ProductItemRequestDTO;
import com.example.mssbilling.dto.ProductItemResponseDTO;
import com.example.mssbilling.entities.Bill;
import com.example.mssbilling.entities.ProductItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {

    ProductItemResponseDTO toProductItemResponseDTO(ProductItem productItem);
    ProductItem toProductItem(ProductItemRequestDTO productItemRequestDTO);


}
