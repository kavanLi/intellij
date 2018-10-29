package com.example.jpa;

import java.util.LinkedList;
import java.util.List;

import com.example.jpa.model.Employee;
import com.example.jpa.model.EmployeeIdentity;
import com.example.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://www.callicoder.com/hibernate-spring-boot-jpa-composite-primary-key-example/
 */
@SpringBootApplication
public class JpaCompositePrimaryKeyDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaCompositePrimaryKeyDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // Cleanup employees table
        employeeRepository.deleteAllInBatch();

        // Insert a new Employee in the database
        Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
                "Rajeev Kumar Singh",
                "rajeev@callicoder.com",
                "+91-9999999999"
        );

        //!!! fields email and phoneNumber is unique, different employee can't be set same email and phoneNumber info.
        Employee employee1 = new Employee(new EmployeeIdentity("E-124", "D-457"),
                "Rajeev Kumar Singh",
                "rajeev@callicoder1.com",
                "+91-9999999998"
        );

        List <Employee> employeeList = new LinkedList <>();
        employeeList.add(employee);
        employeeList.add(employee1);

        employeeRepository.save(employeeList);

        // Retrieving an Employee Record with the composite primary key
        Employee one = employeeRepository.findOne(new EmployeeIdentity("E-123", "D-457"));

        // Retrieving all the employees of a particular company
        List <Employee> byEmployeeIdentityCompanyId = employeeRepository.findByEmployeeIdentityCompanyId("D-457");
    }
}
