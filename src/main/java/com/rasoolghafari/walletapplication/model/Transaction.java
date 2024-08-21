package com.rasoolghafari.walletapplication.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Wallet wallet;

    @Column(name = "transaction_amount")
    private long amount;

    @CreatedDate
    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Version
    @Column(name = "version")
    private int version;

    public Transaction(Wallet wallet, long amount) {
        this.wallet = wallet;
        this.amount = amount;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");

        this.referenceNumber = now.format(formatter);
    }
}