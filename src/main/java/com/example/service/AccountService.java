package com.example.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository; 

    @Autowired
    public AccountService(AccountRepository accountRepository){

        this.accountRepository = accountRepository;
    }
    
    public Account accountLogin(Account account){
        Boolean userBoolean = accountRepository.existsByUsername(account.getUsername());
        Boolean passBoolean = accountRepository.existsByPassword(account.getPassword());
        Account login = accountRepository.getByUsername(account.getUsername());
        if ( passBoolean && userBoolean   ){ 

            return accountRepository.save(login);
        }
        throw new IllegalArgumentException("Account already exists");
    }


    public void registerAccount(Account register){        
        if (accountRepository.existsByUsername(register.getUsername())) {
            throw new IllegalArgumentException("Username already exists");

        }
        accountRepository.save(register);
    }

    


}
