package com.rasoolghafari.walletapplication.service;

import com.rasoolghafari.walletapplication.dto.TransactionResultDTO;
import com.rasoolghafari.walletapplication.exception.ApplicationException;
import com.rasoolghafari.walletapplication.mapper.TransactionMapper;
import com.rasoolghafari.walletapplication.model.Transaction;
import com.rasoolghafari.walletapplication.model.Wallet;
import com.rasoolghafari.walletapplication.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MoneyTransferService {
    private final WalletRepository walletRepository;
    private final WalletService walletService;
    private final TransactionService transactionService;
    private final TransactionMapper mapper;

    @Value("#{messages['invalidWalletId']}")
    private String invalidWalletId;

    @Value("#{messages['insufficientBalance']}")
    private String insufficientBalance;

    public void transferMoney(Long fromWalletId, Long toWalletId, long amount) {
        Optional<Wallet> fromWallet = walletRepository.findById(fromWalletId);
        Optional<Wallet> toWallet = walletRepository.findById(toWalletId);

        if (fromWallet.isPresent() && toWallet.isPresent()) {
            Wallet fWallet = fromWallet.get();
            Wallet tWallet = toWallet.get();
            if (fWallet.getBalance() >= amount) {
                fWallet.setBalance(fWallet.getBalance() - amount);
                tWallet.setBalance(tWallet.getBalance() + amount);
                walletRepository.save(fWallet);
                walletRepository.save(tWallet);
                log.info("Money transferred successfully");
            } else {
                log.error("Insufficient balance");
                throw new ApplicationException(insufficientBalance);
            }
        } else {
            log.error("Invalid wallet id");
            throw new ApplicationException(invalidWalletId);
        }
    }

    @Transactional
    public TransactionResultDTO addMoney(long walletId, long amount) {
        Wallet wallet = walletService.find(walletId);
        wallet.setBalance(wallet.getBalance() + amount);

        if (wallet.getBalance() < 0) {
            throw new ApplicationException("insufficientBalance");
        }

        return mapper.toDto(transactionService.save(wallet, amount));
    }
}