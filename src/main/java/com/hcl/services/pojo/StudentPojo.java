package com.hcl.services.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class StudentPojo {
	@Id
	private Long id;
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date addmissionDate;

	public Date getAddmissionDate() {
		return addmissionDate;
	}

	public void setAddmissionDate(Date addmissionDate) {
		this.addmissionDate = addmissionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
