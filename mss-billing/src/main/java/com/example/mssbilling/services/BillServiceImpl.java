package com.example.mssbilling.services;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;
import com.example.mssbilling.entities.Bill;
import com.example.mssbilling.exceptions.CustomerNotFoundException;
import com.example.mssbilling.mappers.BillMapper;
import com.example.mssbilling.model.Customer;
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
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;
    @Autowired
    private ProductItemService productItemService;

    @Override
    public BillResponseDTO save(BillRequestDTO billRequestDTO) {


       Customer customer =null;
        try {
            // test if customer exist

            customer = customerRestClient.getCustomerById(billRequestDTO.getCustomerId());

        }catch (Exception e)
        {
            throw  new CustomerNotFoundException("customer "+billRequestDTO.getCustomerId()+" not found");

        }

        Bill bill = billMapper.billReuestDtoToBill(billRequestDTO);
        bill.setId(UUID.randomUUID().toString());
        bill.setBillingDate(new Date());


       // save product items
        billRequestDTO.getProductItems().forEach( productItemRequestDTO -> productItemService.save(productItemRequestDTO));

        Bill savedBill = billRepository.save(bill);
        savedBill.setCustomer(customer);

        return billMapper.billToBillResponseDto(savedBill);
    }

    @Override
    public BillResponseDTO update(BillRequestDTO billRequestDTO) {
        Bill bill = billMapper.billReuestDtoToBill(billRequestDTO);
        Bill updatedBill = billRepository.save(bill);

        return billMapper.billToBillResponseDto(updatedBill);
    }

    @Override
    public List<BillResponseDTO> getBillsByCustomerId(String customerId) {

        List<Bill> bills = billRepository.findByCustomerId(customerId);
        bills.forEach(bill -> bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId())) );

        List<BillResponseDTO> billResponseDTOList = bills.stream().map(bill -> billMapper.billToBillResponseDto(bill)).collect(Collectors.toList());

        return billResponseDTOList;
    }

    @Override
    public BillResponseDTO getBill(String id) {

        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));

        return billMapper.billToBillResponseDto(bill);
    }

    @Override
    public List<BillResponseDTO> getBills() {


        List<Bill> bills = billRepository.findAll();

        bills.forEach(bill -> bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId())) );

        List<BillResponseDTO> billResponseDTOList = bills
            .stream()
            .map(bill ->billMapper.billToBillResponseDto(bill) ).collect(Collectors.toList());



        return billResponseDTOList;
    }
}
