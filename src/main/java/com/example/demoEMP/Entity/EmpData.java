package com.example.demoEMP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;

@Entity
@Table(name="EmployeeData")
@Data
public class EmpData {
    private Integer Id;
    private String Name;
    private Integer age;
    private Double Salary;
    private String Company;
}
