package com.example.mssbilling.openfeign;

import com.example.mssbilling.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {




    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable String id);

    @GetMapping(path = "/api/products")
    List<Product> getProducts();

}
