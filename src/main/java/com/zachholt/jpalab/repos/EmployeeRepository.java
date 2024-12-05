package com.zachholt.jpalab.repos;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zachholt.jpalab.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstNameContaining(String firstName);
    long countByReportsToIsNotNull();
    List<Employee> findDistinctByTitleIsNotNull();
    List<Employee> findByTitle(String title);
    List<Employee> findByTitleAndCityAndPostalCodeContaining(String title, String city, String postalCode);
    long countByHireDateGreaterThanEqual(LocalDate hireDate);
    long countByHireDateBetween(LocalDate startDate, LocalDate endDate);
    Employee findFirstByOrderByBirthDateDesc();
}
