package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s")
public class Subcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubCategory;

	private String description;

	private String libelle;

	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	public Subcategory() {
	}

	public Subcategory(String description, String libelle, Category category) {
		super();
		this.description = description;
		this.libelle = libelle;
		this.category = category;
	}

	public int getIdSubCategory() {
		return this.idSubCategory;
	}

	public void setIdSubCategory(int idSubCategory) {
		this.idSubCategory = idSubCategory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}