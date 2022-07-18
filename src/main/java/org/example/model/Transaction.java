package org.example.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {

    private UUID transactionId;
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(UUID transactionId, BigDecimal amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
