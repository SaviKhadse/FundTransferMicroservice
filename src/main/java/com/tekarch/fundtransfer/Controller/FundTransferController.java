package com.tekarch.fundtransfer.Controller;

import com.tekarch.fundtransfer.Model.FundTransfer;
import com.tekarch.fundtransfer.Model.Transaction;
import com.tekarch.fundtransfer.Services.Interfaces.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/fund-transfers")
public class FundTransferController {
//
//    @GetMapping("/fund-transfer")   // passing path parameter
//    public String getCustomers( ) {
//        return "This is FundTransfer docker image running on 8083";
//    }
    private final FundTransferService fundTransferService;

    @Autowired
    public FundTransferController(FundTransferService fundTransferService) {
            this.fundTransferService = fundTransferService;
    }

//    @PostMapping("/initiate")
//    public FundTransfer initiateTransfer(@RequestParam Long senderAccountId,
//                                             @RequestParam Long receiverAccountId,
//                                             @RequestParam BigDecimal amount) {
//        return fundTransferService.initiateTransfer(senderAccountId, receiverAccountId, amount);
//        }
//
//    @GetMapping("/transactions/user/{userId}")
//    public List<Transaction> getTransactionsByUser(@PathVariable Long userId,
//                                                   @RequestParam String type,
//                                                   @RequestParam BigDecimal minAmount,
//                                                   @RequestParam BigDecimal maxAmount) {
//        return fundTransferService.getTransactionsByUser(userId, type, minAmount, maxAmount);
//    }

//    @GetMapping("/transactions/account/{accountId}")
//    public List<Transaction> getTransactionsByAccount(@PathVariable Long accountId) {
//        return fundTransferService.getTransactionsByAccount(accountId);
//    }

//    @GetMapping("/{transferId}")
//    public FundTransfer getTransferDetails(@PathVariable Long transferId) {
//        return fundTransferService.getTransferDetails(transferId);
//    }

}
