package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="Mvtstock.findAll", query="SELECT m FROM Mvtstock m")
public class Mvtstock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMvt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String description;

	private String nature;

	private int qte;

	private int supplier;

	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;

	public Mvtstock() {
	}

	public int getIdMvt() {
		return this.idMvt;
	}

	public void setIdMvt(int idMvt) {
		this.idMvt = idMvt;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getSupplier() {
		return this.supplier;
	}

	public void setSupplier(int supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}