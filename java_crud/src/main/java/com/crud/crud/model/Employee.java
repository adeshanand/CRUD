package com.crud.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "fullName")
	private String fullName;

	@Column(name = "empCode")
	private String empCode;

	@Column(name = "mobile")
	private String mobile;

	public Employee() {

	}

	public Employee(String fullName, String empCode, String mobile) {
		this.fullName = fullName;
		this.empCode = empCode;
		this.mobile = mobile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", empCode=" + empCode + ", mobile=" + mobile + "]";
	}
	
}
