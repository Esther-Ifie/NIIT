package net.banking_api.banking.service;

import net.banking_api.banking.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    // method to create a new employee for EmployeeDto
    EmployeeDto addEmployee(EmployeeDto employeeDto); 

    // method to get account by id
    EmployeeDto getEmployeeById(Long id); 

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    void removeEmployee(Long id);

}