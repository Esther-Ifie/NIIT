package net.banking_api.banking.service.impl;

import net.banking_api.banking.repository.AccountRepository;
import net.banking_api.banking.service.AccountService;
import net.banking_api.entity.Account;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.banking_api.banking.dto.AccountDto;
import net.banking_api.banking.mapper.AccountMapper;
import java.util.List;

@Service

public class AccountServiceImpl implements AccountService {
    
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {

        // initialize accountRepository
        this.accountRepository = accountRepository; 

    }
    
    @Override
    public AccountDto createAccount(AccountDto accountDto){

        // convert DTO to entity
        Account account = AccountMapper.mapToAccount(accountDto); 

        // save entity and capture the saved instance
        Account savedAccount = accountRepository.save(account); 

        // convert the saved entity back to DTO and return
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Account not found with id: " + id)); // fetch account by id or throw exception
                            
        // map and return as AccountDto
        return AccountMapper.mapToAccountDto(account);

    }

    @Override
    public AccountDto deposit(Long id, Double amount) {

        Account account = accountRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Account not found with id: " + id)); // fetch account by id or throw exception
        
        // calculate new balance by adding the deposit amount to the current balance
        Double total = account.getAccountBalance() + amount; 

        // update the balance by adding the deposit amount
        account.setAccountBalance(total); 

        // save the updated account and capture the saved instance
        Account savedAccount = accountRepository.save(account);
        
        // map and return as AccountDto
        return AccountMapper.mapToAccountDto(savedAccount); 
        
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {

        Account account = accountRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Account does not exist"));

        if(account.getAccountBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        }

        Double total = account.getAccountBalance() - amount;
        account.setAccountBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper
        .mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        
        Account account = accountRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Account has been deleted successfully"));
        accountRepository.delete(account);

    }

}

