package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;

	private double buyPrice;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expDate;

	private String libelle;

	private int qte;

	private int criticalZone;

	private double sellPrice;

	private String state;

	private String tag;

	private double tax;

	@ManyToOne
	@JoinColumn(name = "idPromotion")
	private Promotion Promotion;

	@ManyToOne
	@JoinColumn(name = "IdPromotionSuggest_fk")
	private PromotionSuggest promotionSuggest;

	@ManyToOne
	@JoinColumn(name = "IdStore")
	private Store store;

	@ManyToOne
	@JoinColumn(name = "IdSubCategory")
	private Subcategory subcategory;

	public Product(double buyPrice, Date expDate, String libelle, int qte, int criticalZone, double sellPrice,
			String state, String tag, double tax, edu.tunisiamall.entities.Promotion promotion,
			PromotionSuggest promotionSuggest, Store store, Subcategory subcategory) {
		super();
		this.buyPrice = buyPrice;
		this.expDate = expDate;
		this.libelle = libelle;
		this.qte = qte;
		this.criticalZone = criticalZone;
		this.sellPrice = sellPrice;
		this.state = state;
		this.tag = tag;
		this.tax = tax;
		Promotion = promotion;
		this.promotionSuggest = promotionSuggest;
		this.store = store;
		this.subcategory = subcategory;
	}

	public Product(double buyPrice, Date expDate, String libelle, int qte, int criticalZone, double sellPrice,
			String state, String tag, double tax, Store store, Subcategory subcategory) {
		super();
		this.buyPrice = buyPrice;
		this.expDate = expDate;
		this.libelle = libelle;
		this.qte = qte;
		this.criticalZone = criticalZone;
		this.sellPrice = sellPrice;
		this.state = state;
		this.tag = tag;
		this.tax = tax;
		this.store = store;
		this.subcategory = subcategory;
	}

	public Product() {
	}

	public Product(int idProduct, String libelle, int qte, Store store) {
		super();
		this.idProduct = idProduct;
		this.libelle = libelle;
		this.qte = qte;
		this.store = store;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public double getBuyPrice() {
		return this.buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public double getTax() {
		return this.tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Subcategory getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Promotion getPromotion() {
		return Promotion;
	}

	public void setPromotion(Promotion promotion) {
		Promotion = promotion;
	}

	public int getCriticalZone() {
		return criticalZone;
	}

	public void setCriticalZone(int criticalZone) {
		this.criticalZone = criticalZone;
	}

	public PromotionSuggest getPromotionSuggest() {
		return promotionSuggest;
	}

	public void setPromotionSuggest(PromotionSuggest promotionSuggest) {
		this.promotionSuggest = promotionSuggest;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}