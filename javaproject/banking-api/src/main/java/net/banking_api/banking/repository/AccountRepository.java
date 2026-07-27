package net.banking_api.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.banking_api.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}