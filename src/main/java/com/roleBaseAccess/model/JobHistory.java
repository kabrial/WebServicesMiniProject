package com.roleBaseAccess.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the job_history database table.
 * 
 */
@Entity
@Table(name="job_history")
@NamedQuery(name="JobHistory.findAll", query="SELECT j FROM JobHistory j")
public class JobHistory implements Serializable {

	private static final long serialVersionUID = -4005381034843527898L;

	@EmbeddedId
	private JobHistoryPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE", nullable=false)
	private Date endDate;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="DEPARTMENT_ID", referencedColumnName="DEPARTMENT_ID", insertable=false, updatable=false)
	private Employee employee;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="JOB_ID", nullable=false)
	private Job job;

	public JobHistory() {
	}

	public JobHistoryPK getId() {
		return this.id;
	}

	public void setId(JobHistoryPK id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}