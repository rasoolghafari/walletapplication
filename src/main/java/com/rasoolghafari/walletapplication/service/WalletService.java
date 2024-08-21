package com.rasoolghafari.walletapplication.service;

import com.rasoolghafari.walletapplication.dto.BalanceDTO;
import com.rasoolghafari.walletapplication.dto.UserDTO;
import com.rasoolghafari.walletapplication.dto.WalletDTO;
import com.rasoolghafari.walletapplication.exception.ApplicationException;
import com.rasoolghafari.walletapplication.mapper.WalletMapper;
import com.rasoolghafari.walletapplication.model.Wallet;
import com.rasoolghafari.walletapplication.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository repository;
    private final UserService userService;
    private final WalletMapper mapper;

    public WalletDTO createWallet(long userId) {
        Optional<Wallet> byUserId = repository.findByUserId(userId);
        if (byUserId.isPresent()) {
            return mapper.toDto(byUserId.get());
        }

        UserDTO user = userService.find(userId);
        Wallet wallet = mapper.toEntity(new WalletDTO(null, user, 0));
        repository.save(wallet);

        return mapper.toDto(wallet);
    }
    public BalanceDTO getBalance(long userId) {
        Wallet wallet = find(userId);

        return mapper.toBalanceDto(wallet);
    }

    public Wallet find(long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new ApplicationException("walletNotFound"));
    }
}