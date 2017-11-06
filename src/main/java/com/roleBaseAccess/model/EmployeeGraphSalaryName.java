package com.roleBaseAccess.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGraphSalaryName implements Serializable {


    /**
     * 
     */
    private static final long serialVersionUID = 5611127072197996828L;

    @Id
    @Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=10)
    private long employeeId;

    @Column(precision=10, scale=2)
    private BigDecimal salary;
   
       
}
