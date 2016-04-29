package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStroe;

	private String description;

	@ManyToOne
	@JoinColumn(name = "category_fk")
	private Category category;
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date openingDay;

	private String status;

	private String tel;

	public Store(String description, Category category, String name, Date openingDay, String status, String tel,
			Shopowner shopowner) {
		super();
		this.description = description;
		this.category = category;
		this.name = name;
		this.openingDay = openingDay;
		this.status = status;
		this.tel = tel;
		this.shopowner = shopowner;
	}

	@ManyToOne
	@JoinColumn(name = "idUser")
	private Shopowner shopowner;

	public Store() {
	}

	public int getIdStroe() {
		return this.idStroe;
	}

	public void setIdStroe(int idStroe) {
		this.idStroe = idStroe;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDay() {
		return this.openingDay;
	}

	public void setOpeningDay(Date openingDay) {
		this.openingDay = openingDay;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Shopowner getShopowner() {
		return this.shopowner;
	}

	public void setShopowner(Shopowner shopowner) {
		this.shopowner = shopowner;
	}

}