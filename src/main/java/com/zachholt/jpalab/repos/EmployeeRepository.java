package com.zachholt.jpalab.repos;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zachholt.jpalab.models.Employee;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstNameContaining(String firstName);
    long countByReportsToIsNotNull();
    
    @Query("SELECT DISTINCT e.title FROM employees e WHERE e.title IS NOT NULL")
    List<String> findDistinctTitles();
    
    long countByHireDateGreaterThanEqual(LocalDate hireDate);
    long countByHireDateBetween(LocalDate startDate, LocalDate endDate);
    List<Employee> findByTitle(String title);
    List<Employee> findByTitleAndCityAndPostalCodeContaining(String title, String city, String postalCode);
    Employee findFirstByOrderByBirthDateDesc();
}
