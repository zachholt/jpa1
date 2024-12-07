package com.zachholt.jpalab.controllers;

import com.zachholt.jpalab.models.Employee;
import com.zachholt.jpalab.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getEmployeeCount() {
        return ResponseEntity.ok(employeeService.getEmployeeCount());
    }

    @GetMapping("/reporting")
    public ResponseEntity<Long> getReportingEmployees() {
        return ResponseEntity.ok(employeeService.getEmployeeReport());
    }

    @GetMapping("/distinctTitles")
    public ResponseEntity<List<String>> getDistinctTitles() {
        return ResponseEntity.ok(employeeService.getDistinctTitles());
    }

    @GetMapping("/distinctTitles/count")
    public ResponseEntity<Long> getDistinctTitlesCount() {
        return ResponseEntity.ok(employeeService.getDistinctTitlesCount());
    }

    @GetMapping("/hired")
    public ResponseEntity<Long> getEmployeesHiredAfterDate(@RequestParam String date) {
        return ResponseEntity.ok(employeeService.countEmployeesHiredAfterDate(LocalDate.parse(date)));
    }

    @GetMapping("/hired/between")
    public ResponseEntity<Long> getEmployeesHiredBetweenDates(@RequestParam String startDate, 
                                             @RequestParam String endDate) {
        return ResponseEntity.ok(employeeService.countEmployeesHiredBetweenDates(
            LocalDate.parse(startDate), 
            LocalDate.parse(endDate)
        ));
    }

    @GetMapping("/it-staff")
    public ResponseEntity<List<Employee>> getITStaff() {
        return ResponseEntity.ok(employeeService.findEmployeesByTitle("IT Staff"));
    }

    @GetMapping("/it-staff/lethbridge")
    public ResponseEntity<List<Employee>> getITStaffInLethbridge() {
        return ResponseEntity.ok(employeeService.findByTitleAndCityAndPostalCodeContaining("IT Staff", "Lethbridge", "T1H"));
    }

    @GetMapping("/youngest")
    public ResponseEntity<Employee> getYoungestEmployee() {
        return ResponseEntity.ok(employeeService.findYoungestEmployee());
    }

    @PutMapping("/mitchell")
    public ResponseEntity<Employee> updateMitchellName() {
        return ResponseEntity.ok(employeeService.updateName(1, "Mitchell Micheal"));
    }

    @DeleteMapping("/puja")
    public ResponseEntity<String> deletePuja() {
        employeeService.deleteEmployee(2);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}