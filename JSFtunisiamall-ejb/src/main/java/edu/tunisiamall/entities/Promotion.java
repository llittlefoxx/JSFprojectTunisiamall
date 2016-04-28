package edu.tunisiamall.entities;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity

public class Promotion implements Serializable {

	@Id
	private Long idPromotion;
	private String name;
	private double value;
	private boolean state;
	private Date startDate;
	private Date endDate;

	private static final long serialVersionUID = 1L;

	public Promotion() {
		super();
	}

	public Long getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(Long idPromotion) {
		this.idPromotion = idPromotion;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Promotion(String name, double value, boolean state, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.value = value;
		this.state = state;
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
