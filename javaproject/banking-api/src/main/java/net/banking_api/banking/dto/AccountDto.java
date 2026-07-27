package net.banking_api.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //generates getters and setters
@AllArgsConstructor //annotation for any constructor meant to be called
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private int accountNumber;
    private String accountType;
    private String accountHolderName;
    private double accountBalance;

}
