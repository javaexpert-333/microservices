package com.javaexpert.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaexpert.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
