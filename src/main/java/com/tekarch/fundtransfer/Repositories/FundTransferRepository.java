package com.tekarch.fundtransfer.Repositories;

import com.tekarch.fundtransfer.Model.FundTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {

}
