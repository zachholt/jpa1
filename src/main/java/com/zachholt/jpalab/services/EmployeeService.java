package com.zachholt.jpalab.services;

import com.zachholt.jpalab.models.Employee;
import com.zachholt.jpalab.repos.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public long getEmployeeCount() {
        return employeeRepository.count();
    }

    public long getEmployeeReport() {
        return employeeRepository.countByReportsToIsNotNull();
    }

    public List<String> getDistinctTitles() {
        return employeeRepository.findDistinctTitles();
    }

    public long getDistinctTitlesCount() {
        return getDistinctTitles().size();
    }

    public List<Employee> getFirstByFirstName(String firstName) {
        return employeeRepository.findByFirstNameContaining(firstName);
    }

    public List<Employee> findEmployeesByTitle(String title) {
        return employeeRepository.findByTitle(title);
    }

    public List<Employee> findByTitleAndCityAndPostalCodeContaining(String title, String city, String postalCode) {
        return employeeRepository.findByTitleAndCityAndPostalCodeContaining(title, city, postalCode);
    }

    public long countEmployeesHiredAfterDate(LocalDate date) {
        return employeeRepository.countByHireDateGreaterThanEqual(date);
    }

    public long countEmployeesHiredBetweenDates(LocalDate startDate, LocalDate endDate) {
        return employeeRepository.countByHireDateBetween(startDate, endDate);
    }

    public Employee findYoungestEmployee() {
        return employeeRepository.findFirstByOrderByBirthDateDesc();
    }

    public Employee updateName(Integer id, String newName) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        employee.setFirstName(newName);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}