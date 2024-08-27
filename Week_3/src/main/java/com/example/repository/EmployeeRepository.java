package com.example.repository;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
@Qualifier("primaryDataSource")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by name containing a specific string (case-insensitive)
    List<Employee> findByNameIgnoreCaseContaining(String name);

    // Find employees by email
    Employee findByEmail(String email);
    
    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    @Query(name = "Employee.findByNamePattern")
    List<Employee> findByNamePattern(@Param("namePattern") String namePattern);
    
    // Custom query to find employees by department ID
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);
    
    // Pagination support for finding employees by department name
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    // Pagination support for finding all employees
    Page<Employee> findAll(Pageable pageable);
    
 // Use projection to fetch specific fields
    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, d.name AS departmentName FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeProjections();
    
    @Query("SELECT new com.example.employeemanagement.projection.EmployeeDTO(e.id, e.name, e.email, d.name) FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findAllEmployeeDTOs();

}