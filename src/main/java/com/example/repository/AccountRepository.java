package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

    Boolean existsByUsername(String username);

    Boolean existsByPassword(String password);
    
    Account getByUsername(String username);

    Boolean existsByAccountId(Integer accountId);


}

