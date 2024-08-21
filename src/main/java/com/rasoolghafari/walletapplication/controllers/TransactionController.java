package com.rasoolghafari.walletapplication.controllers;

import com.rasoolghafari.walletapplication.dto.BalanceDTO;
import com.rasoolghafari.walletapplication.dto.TransactionDTO;
import com.rasoolghafari.walletapplication.dto.WalletDTO;
import com.rasoolghafari.walletapplication.service.TransactionService;
import com.rasoolghafari.walletapplication.service.WalletService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@SecurityRequirement(name = "walletapplication")
public class TransactionController {
    private final TransactionService service;


    @GetMapping("/list")
    public ResponseEntity<List<TransactionDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

}