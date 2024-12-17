package com.tekarch.fundtransfer.Services.Interfaces;

import com.tekarch.fundtransfer.Model.FundTransfer;
import com.tekarch.fundtransfer.Model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface FundTransferService {

    FundTransfer initiateTransfer(Long senderAccountId, Long receiverAccountId, BigDecimal amount);

//    List<Transaction> getTransactionsByUser(Long userId, String type, BigDecimal minAmount, BigDecimal maxAmount);

//    List<Transaction> getTransactionsByAccount(Long accountId);

    FundTransfer getTransferDetails(Long transferId);

    boolean validateTransactionLimit(Long accountId, BigDecimal amount);

    FundTransfer createScheduledTransfer(Long senderAccountId, Long receiverAccountId, BigDecimal amount, LocalDateTime scheduledDate);

}