package com.example.mssbilling.repositories;

import com.example.mssbilling.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

public interface ProductItemRepository extends JpaRepository<ProductItem,String> {
     public Collection<ProductItem> findByBillId(String id);
}
