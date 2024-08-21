package com.rasoolghafari.walletapplication.service;

import com.rasoolghafari.walletapplication.dto.TransactionDTO;
import com.rasoolghafari.walletapplication.mapper.TransactionMapper;
import com.rasoolghafari.walletapplication.model.Transaction;
import com.rasoolghafari.walletapplication.model.Wallet;
import com.rasoolghafari.walletapplication.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Transactional(readOnly = true)
    public long getTotalCount() {
        return repository.count();
    }

    public List<TransactionDTO> list() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional
    public Transaction save(Wallet wallet, long amount) {
        return repository.save(new Transaction(wallet, amount));
    }
}
