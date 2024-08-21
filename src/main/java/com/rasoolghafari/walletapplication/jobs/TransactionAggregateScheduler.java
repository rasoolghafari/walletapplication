package com.rasoolghafari.walletapplication.jobs;

import com.rasoolghafari.walletapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionAggregateScheduler {

    private final TransactionService transactionService;

    @Scheduled(fixedDelay = 1000)
    public void logTransaction() {
        log.info("all transaction count {}", transactionService.getTotalCount());
    }
}
