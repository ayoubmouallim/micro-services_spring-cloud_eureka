package com.example.mssbilling.services;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;
import com.example.mssbilling.dto.ProductItemRequestDTO;
import com.example.mssbilling.dto.ProductItemResponseDTO;
import com.example.mssbilling.entities.Bill;
import com.example.mssbilling.entities.ProductItem;
import com.example.mssbilling.mappers.BillMapper;
import com.example.mssbilling.mappers.ProductItemMapper;
import com.example.mssbilling.openfeign.CustomerRestClient;
import com.example.mssbilling.openfeign.ProductRestClient;
import com.example.mssbilling.repositories.BillRepository;
import com.example.mssbilling.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductItemServiceImpl implements ProductItemService {


    @Autowired
    private ProductItemMapper productItemMapper;
    @Autowired
    private ProductItemRepository productItemRepository;





    @Override
    public ProductItemResponseDTO save(ProductItemRequestDTO productItemRequestDTO) {

        ProductItem productItem =  productItemMapper.toProductItem(productItemRequestDTO);
        productItem.setId(UUID.randomUUID().toString());

        // test if product id exist

        ProductItem savedProductItem = productItemRepository.save(productItem);

        return productItemMapper.toProductItemResponseDTO(savedProductItem);
    }
}
