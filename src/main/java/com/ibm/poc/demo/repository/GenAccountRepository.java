package com.ibm.poc.demo.repository;

import com.ibm.poc.demo.entity.GenAccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenAccountRepository extends CrudRepository<GenAccount, Long> {

}
