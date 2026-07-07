package net.banking_api.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //generates getters and setters
@AllArgsConstructor //annotation for any constructor meant to be called
@NoArgsConstructor
public class EmployeeDto {
    
    private Long id;
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;

}
