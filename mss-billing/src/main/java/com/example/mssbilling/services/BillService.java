package com.example.mssbilling.services;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;

import java.util.List;

public interface BillService {
    BillResponseDTO save(BillRequestDTO billRequestDTO);
    BillResponseDTO update(BillRequestDTO billRequestDTO);
    List<BillResponseDTO> getBillsByCustomerId(String customerId);
    BillResponseDTO getBill(String id);
    List<BillResponseDTO>  getBills();

}
