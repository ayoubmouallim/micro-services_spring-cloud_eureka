package com.example.mssbilling.mappers;

import com.example.mssbilling.dto.BillRequestDTO;
import com.example.mssbilling.dto.BillResponseDTO;
import com.example.mssbilling.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillResponseDTO billToBillResponseDto(Bill bill);
    Bill billReuestDtoToBill(BillRequestDTO billRequestDTO);


}
