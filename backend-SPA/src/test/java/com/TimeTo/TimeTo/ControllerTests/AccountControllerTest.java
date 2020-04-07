package com.TimeTo.TimeTo.ControllerTests;

import com.TimeTo.TimeTo.Controllers.AccountController;
import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Models.Calendar;
import com.TimeTo.TimeTo.Models.UserAccount;
import com.TimeTo.TimeTo.Repositories.AccountRepository;
import com.TimeTo.TimeTo.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DirtiesContext
public class AccountControllerTest {
    private AccountRepository accountRepository;
    private AccountController underTest;
    private Account testAccount;
    private UserRepository userRepository;
    private UserAccount testUserAccount;
    private Calendar testCalendar;

    @BeforeEach
    void setUp(){
        testCalendar = new Calendar();
        accountRepository = mock(AccountRepository.class);
        underTest = new AccountController(accountRepository);
        testUserAccount= new UserAccount("Stuart", "Maxwell", "stumax7");
        userRepository = mock(UserRepository.class);
        testAccount = new Account(testUserAccount, testCalendar);
        userRepository.save(testUserAccount);
        accountRepository.save(testAccount);
        when(accountRepository.findAll()).thenReturn(Collections.singletonList(testAccount));
        when(accountRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(testAccount));
    }

    @Test
    public void AccountShouldHaveACalendar(){

    }
}
