package net_banking_api.banking_api.banking.mapper;

import net_banking_api.banking_api.banking.dto.AccountDto;
import net_banking_api.banking_api.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){

        Account account = new Account(
            accountDto.getId(),
            accountDto.getAccountNumber(),
            accountDto.getAccountType(),
            accountDto.getAccountHolderName(),
            accountDto.getAccountBalance()  
        );

        return account;

    }

    public static AccountDto mapToAccountDto(Account account){

        AccountDto accountDto = new AccountDto(
            account.getId(),
            account.getAccountNumber(),
            account.getAccountType(),
            account.getAccountHolderName(),
            account.getAccountBalance()  
        );

        return accountDto;
    }


}
