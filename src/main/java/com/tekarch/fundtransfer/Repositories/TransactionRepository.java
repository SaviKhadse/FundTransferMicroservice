package com.tekarch.fundtransfer.Repositories;

import com.tekarch.fundtransfer.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Find all transactions for an account
    List<Transaction> findByAccountId(Long accountId);

    // Find transactions by user-specific criteria
    @Query("SELECT t FROM Transaction t WHERE t.accountId IN :accountIds AND t.amount BETWEEN :minAmount AND :maxAmount")
    List<Transaction> findByUserCriteria(@Param("accountIds") List<Long> accountId, @Param("minAmount") BigDecimal min, @Param("maxAmount") BigDecimal max);

    //Query for transactions based on accountIds and other criteria (type, minAmount, maxAmount)
    //List<Transaction> findByAccountIdsAndCriteria(List<Long> accountId, String type, BigDecimal minAmount, BigDecimal maxAmount);

    // Corrected method in the repository
    //List<Transaction> findByAccountIdInAndTransactionTypeAndAmountBetween(
    //List<Long> accountId, String type, BigDecimal minAmount, BigDecimal maxAmount);


//    List<Transaction> findByAccountIdInAndTransactionTypeAndAmountBetween(
//            List<Long> accountIds, String type, BigDecimal minAmount, BigDecimal maxAmount);


}
