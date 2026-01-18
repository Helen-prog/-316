package org.springsecurity.securityappproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity.securityappproject.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {
    public Employee findByEmail(String email);
}
