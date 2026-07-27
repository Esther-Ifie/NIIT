package net.banking_api.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.banking_api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}