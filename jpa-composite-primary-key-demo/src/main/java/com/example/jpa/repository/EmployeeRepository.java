package com.example.jpa.repository;

import java.util.List;

import com.example.jpa.model.Employee;
import com.example.jpa.model.EmployeeIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * class description goes here.
 */
@Repository
public interface EmployeeRepository extends JpaRepository <Employee, EmployeeIdentity> {
    /*
       Spring Data JPA will automatically parse this method name
       and create a query from it
    */
    List <Employee> findByEmployeeIdentityCompanyId(String companyId);
}
