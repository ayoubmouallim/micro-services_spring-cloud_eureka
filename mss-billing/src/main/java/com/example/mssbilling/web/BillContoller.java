package com.example.mssbilling.web;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;
import com.example.mssbilling.entities.Bill;
import com.example.mssbilling.exceptions.CustomerNotFoundException;
import com.example.mssbilling.repositories.BillRepository;
import com.example.mssbilling.repositories.ProductItemRepository;
import com.example.mssbilling.openfeign.CustomerRestClient;
import com.example.mssbilling.openfeign.ProductRestClient;
import com.example.mssbilling.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillContoller {

    @Autowired
    private BillService billService;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    ProductRestClient productRestClient;



    @GetMapping("/bills/{id}")
    public BillResponseDTO getBillById(@PathVariable(name = "id") String id)
    {
        return billService.getBill(id);
    }

    @GetMapping("bills")
    public List<BillResponseDTO> getBills(){
        return billService.getBills();
    }

    @GetMapping("/bills/customer/{customerId}")
    public List<BillResponseDTO> getBillsByCustomerId(@PathVariable(name = "customerId") String customerId)
    {
        return billService.getBillsByCustomerId(customerId);
    }

    @PostMapping("/bills")
    public BillResponseDTO save(@RequestBody BillRequestDTO billRequestDTO)
    {
        return billService.save(billRequestDTO);
    }

    @PutMapping("/bills")
    public BillResponseDTO update(@RequestBody BillRequestDTO billRequestDTO)
    {
        return billService.update(billRequestDTO);
    }

@ExceptionHandler(Exception.class )
    public ResponseEntity<String> exceptionHandler(Exception e)
    {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
