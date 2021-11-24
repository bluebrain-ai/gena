package com.ibm.poc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IgenerateAccountRepository extends JpaRepository<GenAccount, Long> {

    @Modifying
    @Query("update GenAccoun g set g.customerNumber = :customerNumber")
    void updateCustomerNumber(@Param("customerNumber") Long customerNumber);
}
