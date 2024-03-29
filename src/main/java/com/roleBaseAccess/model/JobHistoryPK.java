package com.roleBaseAccess.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the job_history database table.
 * 
 */
@Embeddable
public class JobHistoryPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5827821043088530408L;

	//default serial version id, required for serializable classes.

	@Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=10)
	private long employeeId;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE", unique=true, nullable=false)
	private java.util.Date startDate;

	public JobHistoryPK() {
	}
	public long getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobHistoryPK)) {
			return false;
		}
		JobHistoryPK castOther = (JobHistoryPK)other;
		return 
			(this.employeeId == castOther.employeeId)
			&& this.startDate.equals(castOther.startDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.employeeId ^ (this.employeeId >>> 32)));
		hash = hash * prime + this.startDate.hashCode();
		
		return hash;
	}
}