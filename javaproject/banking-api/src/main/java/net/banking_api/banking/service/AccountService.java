package net.banking_api.banking.service;

import net.banking_api.banking.dto.AccountDto;
import java.util.List;
// import net.banking_api.entity.Account;

public interface AccountService {

    // method to create a new account for AccountDto
    AccountDto createAccount(AccountDto accountDto); 

    // method to get account by id
    AccountDto getAccountById(Long id); 

    // method to deposit amount to account by id
    AccountDto deposit(Long id, Double amount); 

    // method to withdraw amount from account by id
    AccountDto withdraw(Long id, Double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

}