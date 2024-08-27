package com.example.service;

import com.example.model.Employee;
import com.example.employeemanagement.projection.EmployeeProjection;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Page<Employee> getEmployeesByDepartment(String departmentName, Pageable pageable) {
        return employeeRepository.findByDepartmentName(departmentName, pageable);
    }
    
    // Method to get employee projection data
    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findAllEmployeeProjections();
    }
    
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.findAllEmployeeDTOs();
    }
    
    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        int batchSize = 20; // Same as the configured batch size
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                employeeRepository.flush(); // Flush a batch of inserts
            }
        }
        employeeRepository.flush(); // Final flush to ensure all records are saved
    }

}
