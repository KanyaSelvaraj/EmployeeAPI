package com.corporate.employee.entity;


import com.corporate.employee.constants.EmployeeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(
  name = "employee"
)
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private EmployeeEnum department ;
    private Integer workingHours;
    @Embedded
    private Address address;
}
