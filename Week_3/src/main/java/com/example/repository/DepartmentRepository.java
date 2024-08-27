package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Department;

import java.util.Optional;

@Repository
@Qualifier("secondaryDataSource")
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	// Find a department by name
    Optional<Department> findByName(String name);
}