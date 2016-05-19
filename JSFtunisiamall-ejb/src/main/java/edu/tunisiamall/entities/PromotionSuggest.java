package edu.tunisiamall.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@NamedQuery(name = "PromotionSuggest.findAll", query = "SELECT p FROM PromotionSuggest p")
public class PromotionSuggest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPromotionSuggest;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date suggestionDate;

	private String desccription;

	private double value;

	public PromotionSuggest() {
		super();
	}

	public int getIdPromotionSuggest() {
		return idPromotionSuggest;
	}

	public void setIdPromotionSuggest(int idPromotionSuggest) {
		this.idPromotionSuggest = idPromotionSuggest;
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

	public Date getSuggestionDate() {
		return suggestionDate;
	}

	public void setSuggestionDate(Date suggestionDate) {
		this.suggestionDate = suggestionDate;
	}

	public String getDesccription() {
		return desccription;
	}

	public void setDesccription(String desccription) {
		this.desccription = desccription;
	}

	public double getValue() {
		return value;
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

}
