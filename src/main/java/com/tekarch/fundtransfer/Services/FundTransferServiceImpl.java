package com.tekarch.fundtransfer.Services;

import com.tekarch.fundtransfer.Model.FundTransfer;
import com.tekarch.fundtransfer.Model.Transaction;
import com.tekarch.fundtransfer.Repositories.FundTransferRepository;
import com.tekarch.fundtransfer.Repositories.TransactionRepository;
import com.tekarch.fundtransfer.Services.Interfaces.FundTransferService;
import com.tekarch.fundtransfer.config.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FundTransferServiceImpl implements FundTransferService {

    @Autowired
    private final RestTemplate restTemplate;

    private final FundTransferRepository fundTransferRepository;
    private final TransactionRepository transactionRepository;

    private final String accountServiceUrl = "http://localhost:8081/accounts"; // URL of the Account Microservice
    private final String userServiceUrl = "http://localhost:8080/users"; // URL of the User Microservice

    // @Autowired
//    public FundTransferServiceImpl(RestTemplate restTemplate, FundTransferRepository fundTransferRepository, TransactionRepository transactionRepository) {
//        this.restTemplate = restTemplate;
//        this.fundTransferRepository = fundTransferRepository;
//        this.transactionRepository = transactionRepository;
//    }

    public FundTransferServiceImpl(
            FundTransferRepository fundTransferRepository,
            TransactionRepository transactionRepository,
            //AccountRepository accountRepository,
            RestTemplate restTemplate) {
        this.fundTransferRepository = fundTransferRepository;
        this.transactionRepository = transactionRepository;
        //this.accountRepository = accountRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public FundTransfer initiateTransfer(Long senderAccountId, Long receiverAccountId, BigDecimal amount) {
        // Check for valid transaction amount (within limit, valid accounts, etc.)
        FundTransfer fundTransfer = new FundTransfer();
        fundTransfer.setSenderAccountId(senderAccountId);
        fundTransfer.setReceiverAccountId(receiverAccountId);
        fundTransfer.setAmount(amount);
        // Set status as 'completed' after performing necessary actions
        fundTransfer.setStatus("completed");
        return fundTransferRepository.save(fundTransfer);
    }



//    @Override
//    public List<Transaction> getTransactionsByUser(Long userId, String type, BigDecimal minAmount, BigDecimal maxAmount) {
//        // Query transactions by user ID (after mapping userId to account IDs if needed)
//        // For simplicity, let's assume userId is directly tied to accountId
    ////        List<Long> accountIds = // Logic to get account IDs by userId
    ////        return transactionRepository.findByUserCriteria(accountIds, minAmount, maxAmount);
//
//        // Call to Account service to fetch account IDs for the user
//        String accountServiceUrl = "http://account-service/accounts/user/" + userId;
//        AccountDTO[] accountDTOs = restTemplate.getForObject(accountServiceUrl, AccountDTO[].class);
//
//        if (accountDTOs == null || accountDTOs.length == 0) {
//            throw new ResourceNotFoundException("No accounts found for user with ID " + userId);
//        }
//
//        // Convert AccountDTO[] to List<Long> accountIds
//        List<Long> accountIds = Arrays.stream(accountDTOs)
//                .map(AccountDTO::getAccountId)
//                .collect(Collectors.toList());
//
//        // Use the correct method name with accountId
//        return transactionRepository.findByAccountIdInAndTransactionTypeAndAmountBetween(
//                accountIds, type, minAmount, maxAmount);
//
//
//    }

//    @Override
//    public List<Transaction> getTransactionsByAccount(Long accountId) {
//        return transactionRepository.findByAccountId(accountId);
//    }

    @Override
    public FundTransfer getTransferDetails(Long transferId) {
        return fundTransferRepository.findById(transferId)
                .orElseThrow(() -> new ResourceNotFoundException("Transfer not found with ID " + transferId));
    }

    @Override
    public boolean validateTransactionLimit(Long accountId, BigDecimal amount) {
        // Logic to check if the transaction amount is within the limits for the account
        return true; // Simplified for this example
    }

    @Override
    public FundTransfer createScheduledTransfer(Long senderAccountId, Long receiverAccountId, BigDecimal amount, LocalDateTime scheduledDate) {
        FundTransfer scheduledTransfer = new FundTransfer();
        scheduledTransfer.setSenderAccountId(senderAccountId);
        scheduledTransfer.setReceiverAccountId(receiverAccountId);
        scheduledTransfer.setAmount(amount);
        scheduledTransfer.setStatus("scheduled");
        // Logic to handle scheduled transfers (like next execution date)
        return fundTransferRepository.save(scheduledTransfer);
    }
}


