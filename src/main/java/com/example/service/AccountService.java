package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
    
    AccountRepository accountRepository; 

    @Autowired
    public AccountService(AccountRepository accountRepository){

        this.accountRepository = accountRepository;
    }

    // public Account accountLogin(Account account){
    //     return accountRepository.login(account.getUsername(), account.getPassword());
    // }

    // public Account registerAccount(Account account){
    //     return accountRepository.registerAccount(account);
    // }




}
