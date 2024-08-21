package com.rasoolghafari.walletapplication.dto;

import java.time.Instant;

public record TransactionDTO(String id, WalletDTO wallet, long amount, Instant createdDate, String referenceNumber) {
}
