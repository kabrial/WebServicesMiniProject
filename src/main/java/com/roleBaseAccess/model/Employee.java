package com.roleBaseAccess.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {

	private static final long serialVersionUID = 7750917046576374697L;

	@Id
	@Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=10)
	private long employeeId;

	@Column(name="COMMISSION_PCT", precision=10, scale=2)
	private BigDecimal commissionPct;

	@Column(nullable=false, length=25)
	private String email;

	@Column(name="FIRST_NAME", length=20)
	private String firstName;

	//@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE", nullable=false)
	private String hireDate;

	@Column(name="LAST_NAME", nullable=false, length=25)
	private String lastName;

	@Column(name="MANAGER_ID", precision=10)
	private BigDecimal managerId;

	@Column(name="PHONE_NUMBER", length=20)
	private String phoneNumber;

	@Column(precision=10, scale=2)
	private BigDecimal salary;

	//bi-directional many-to-one association to Department
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="JOB_ID", nullable=false)
	private Job job;

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}