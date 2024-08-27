package com.example.controller;

import com.example.model.Employee;
import com.example.projection.EmployeeProjection;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public Page<Employee> getEmployees(
        @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return employeeService.getEmployees(pageable);
    }

    @GetMapping("/search")
    public Page<Employee> searchEmployeesByDepartment(
        @RequestParam String departmentName,
        @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return employeeService.getEmployeesByDepartment(departmentName, pageable);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            Employee updatedEmployee = employee.get();
            updatedEmployee.setName(employeeDetails.getName());
            updatedEmployee.setEmail(employeeDetails.getEmail());
            updatedEmployee.setDepartment(employeeDetails.getDepartment());
            return ResponseEntity.ok(employeeService.saveEmployee(updatedEmployee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to get employee projection data
    @GetMapping("/projections")
    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeService.getEmployeeProjections();
    }
    
    @GetMapping("/dto")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeService.getEmployeeDTOs();
    }

}
