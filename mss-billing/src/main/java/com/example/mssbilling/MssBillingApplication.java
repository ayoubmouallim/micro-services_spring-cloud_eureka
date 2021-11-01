package com.example.mssbilling;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;
import com.example.mssbilling.dto.ProductItemRequestDTO;
import com.example.mssbilling.entities.Bill;
import com.example.mssbilling.entities.ProductItem;
import com.example.mssbilling.model.Customer;
import com.example.mssbilling.model.Product;
import com.example.mssbilling.repositories.BillRepository;
import com.example.mssbilling.repositories.ProductItemRepository;
import com.example.mssbilling.openfeign.CustomerRestClient;
import com.example.mssbilling.openfeign.ProductRestClient;
import com.example.mssbilling.services.BillService;
import com.example.mssbilling.services.ProductItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class MssBillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MssBillingApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BillService billService, ProductItemService productItemService, ProductRestClient productRestClient)
    {
        return args -> {

            List<ProductItemRequestDTO> plist = new ArrayList<>();
            plist.add(new ProductItemRequestDTO(1,123,"p01",null));


            billService.save(new BillRequestDTO( plist,"c01", Double.valueOf(1080)));
            billService.save(new BillRequestDTO( plist,"c02", Double.valueOf(1090)));
            billService.save(new BillRequestDTO( plist,"c03", Double.valueOf(1280)));




        };
    }

}
