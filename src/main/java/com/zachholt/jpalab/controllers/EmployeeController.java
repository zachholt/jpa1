package com.zachholt.jpalab.controllers;

import com.zachholt.jpalab.models.Employee;
import com.zachholt.jpalab.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/countAllEmployees")
    public ResponseEntity<Long> countAllEmployees() {
        return ResponseEntity.ok(employeeService.getEmployeeCount());
    }

    @GetMapping("/reportingEmployees")
    public ResponseEntity<Long> getEmployeeReport() {
        return ResponseEntity.ok(employeeService.getEmployeeReport());
    }

    @GetMapping("/titles")
    public ResponseEntity<List<String>> getDistinctTitles() {
        return ResponseEntity.ok(employeeService.getDistinctTitles());
    }

    @GetMapping("/titles/count")
    public ResponseEntity<Long> getDistinctTitlesCount() {
        return ResponseEntity.ok(employeeService.getDistinctTitlesCount());
    }

    @GetMapping("/findByFirstName/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(employeeService.getFirstByFirstName(firstName));
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<List<Employee>> findEmployeesByTitle(@PathVariable String title) {
        return ResponseEntity.ok(employeeService.findEmployeesByTitle(title));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> findByTitleAndCityAndPostalCodeContaining(
            @RequestParam String title,
            @RequestParam String city,
            @RequestParam String postalCode) {
        return ResponseEntity.ok(
            employeeService.findByTitleAndCityAndPostalCodeContaining(title, city, postalCode)
        );
    }

    @GetMapping("/countHiredAfter/{date}")
    public ResponseEntity<Long> countEmployeesHiredAfterDate(@PathVariable String date) {
        LocalDate hireDate = LocalDate.parse(date);
        return ResponseEntity.ok(employeeService.countEmployeesHiredAfterDate(hireDate));
    }

    @GetMapping("/countHiredBetween")
    public ResponseEntity<Long> countEmployeesHiredBetweenDates(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(employeeService.countEmployeesHiredBetweenDates(start, end));
    }

    @GetMapping("/youngest")
    public ResponseEntity<Employee> findYoungestEmployee() {
        return ResponseEntity.ok(employeeService.findYoungestEmployee());
    }
}