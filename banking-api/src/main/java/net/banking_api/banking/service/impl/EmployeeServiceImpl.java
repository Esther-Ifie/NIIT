package net.banking_api.banking.service.impl;

import net.banking_api.banking.repository.EmployeeRepository;
import net.banking_api.banking.service.EmployeeService;
import net.banking_api.entity.Employee;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.banking_api.banking.dto.EmployeeDto;
import net.banking_api.banking.mapper.EmployeeMapper;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    
    private EmployeeRepository employeeRepository;
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        // initialize EmployeeRepository
        this.employeeRepository = employeeRepository;

    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto){

        // convert DTO to entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto); 

        // save entity and capture the saved instance
        Employee savedEmployee = employeeRepository.save(employee); 

        // convert the saved entity back to DTO and return
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Employee does not exist")); // fetch Employee by id or throw exception
                            
        // map and return as EmployeeDto
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Employee employee = employeeRepository
                                    .findById(id)
                                    .orElseThrow(() -> new RuntimeException("Employee does not exist")); // fetch Employee by id or throw exception

        // update fields
        employee.setName(employeeDto.getName());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setEmail(employeeDto.getEmail());

        // save the updated employee and return as DTO
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);

    }

    @Override
    public void removeEmployee(Long id) throws RuntimeException {
        
        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Employee has been deleted successfully"));
                            
        employeeRepository.delete(employee);

    }

}

