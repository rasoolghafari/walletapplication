package com.rasoolghafari.walletapplication.controllers;

import com.rasoolghafari.walletapplication.dto.TransactionResultDTO;
import com.rasoolghafari.walletapplication.service.MoneyTransferService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transfers")
@SecurityRequirement(name = "walletapplication")
public class MoneyTransferController {
    private final MoneyTransferService moneyTransferService;

    @PutMapping("/{walletId}/add/{amount}")
    public ResponseEntity<TransactionResultDTO> addMoney(@PathVariable long walletId, @PathVariable long amount) {
        TransactionResultDTO result = moneyTransferService.addMoney(walletId, amount);
        return ResponseEntity.ok(result);
    }
}