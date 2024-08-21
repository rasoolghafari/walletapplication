package com.rasoolghafari.walletapplication.controllers;

import com.rasoolghafari.walletapplication.dto.BalanceDTO;
import com.rasoolghafari.walletapplication.dto.WalletDTO;
import com.rasoolghafari.walletapplication.service.WalletService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
@SecurityRequirement(name = "walletapplication")
public class WalletController {
    private final WalletService service;

    @PostMapping("/{userId}")
    public ResponseEntity<WalletDTO> createWallet(@PathVariable long userId) {
        WalletDTO createdWallet = service.createWallet(userId);
        return ResponseEntity.ok(createdWallet);
    }

    @GetMapping("/get-balance/{userId}")
    public ResponseEntity<BalanceDTO> getBalance(@PathVariable long userId) {
        return ResponseEntity.ok(service.getBalance(userId));
    }
}