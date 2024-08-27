package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

	@Autowired
    private EmployeeService employeeService;

    @Test
    public void testBatchInsert() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setName("Employee " + i);
            employee.setEmail("employee" + i + "@example.com");
            employees.add(employee);
        }
        employeeService.batchInsertEmployees(employees);
    }
}
