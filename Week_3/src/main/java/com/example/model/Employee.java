package com.example.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByDepartmentName",
        query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName"
    ),
    @NamedQuery(
        name = "Employee.findByNamePattern",
        query = "SELECT e FROM Employee e WHERE e.name LIKE :namePattern"
    )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @NaturalId
    private String email;
    
    @Formula("(select count(*) from projects p where p.employee_id = id)")
    private int projectCount;


    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}