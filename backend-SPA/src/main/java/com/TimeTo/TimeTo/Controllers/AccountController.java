package com.TimeTo.TimeTo.Controllers;

import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Models.UserAccount;
import com.TimeTo.TimeTo.Repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/account/{username}")
    public List<String> getFriendsOfUsername(@PathVariable String username){
        Account retrievedAccount = accountRepository.findByUsername(username).get();
        Set<UserAccount> friendsListUser = retrievedAccount.getFriends();
        List<String> friendsList = new ArrayList<>();
        for (UserAccount userAccount: friendsListUser) {
            String retrievedName = userAccount.getUserName();
            friendsList.add(retrievedName);
        }
        return friendsList;
    }
}
