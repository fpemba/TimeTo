package com.TimeTo.TimeTo.Controllers;

import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController (AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts/")
    public Collection<Account> retrieveAccounts(){
        return (Collection<Account>) accountRepository.findAll();
    }
}
