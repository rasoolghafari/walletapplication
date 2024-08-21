package com.rasoolghafari.walletapplication.mapper;

import com.rasoolghafari.walletapplication.dto.TransactionDTO;
import com.rasoolghafari.walletapplication.dto.TransactionResultDTO;
import com.rasoolghafari.walletapplication.model.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionResultDTO toDto(Transaction entity);
    List<TransactionDTO> toDto(List<Transaction> entity);
}