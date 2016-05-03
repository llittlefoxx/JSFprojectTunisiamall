package edu.formutility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import edu.tunisiamall.biservices.IndicatorsServiceLocal;
import edu.tunisiamall.categorieServices.CategoryServicesLocal;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.entities.Subcategory;
import edu.tunisiamall.shopOwnerServices.shopOwnerService;
import edu.tunisiamall.storeServices.StoreServicesLocal;
import edu.tunisiamall.subCategoriesServices.SubCategoriesServicesLocal;

@ManagedBean(name = "foView")
public class ProductModel {

	@EJB
	CategoryServicesLocal categoryServices;

	@EJB
	StoreServicesLocal storeserv;

	@EJB
	IndicatorsServiceLocal indicators;

	@EJB
	SubCategoriesServicesLocal subcategoryserv;

	@PostConstruct
	public void init() {
		categorys = categoryServices.findAll();
		promotions = indicators.getAllPromotions();
		for (Category category : categorys) {
			categoryss.add(category.getLibelle());
		}
	}

	private List<Category> categorys;
	private List<String> categoryss = new ArrayList<String>();

	private Promotion selectedpromotion;
	private List<Promotion> promotions;

	private int idProduct;

	private String libelle;

	private int qte;

	private int criticalZone;

	private double sellPrice;

	private String state;

	private String tag;

	private double tax;

	private Date expDate;

	private double buyPrice;

	private String imgPath;

	private String selectedCategory;

	public Promotion getSelectedpromotion() {
		return selectedpromotion;
	}

	public void setSelectedpromotion(Promotion selectedpromotion) {
		this.selectedpromotion = selectedpromotion;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getCriticalZone() {
		return criticalZone;
	}

	public void setCriticalZone(int criticalZone) {
		this.criticalZone = criticalZone;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public List<String> getCategoryss() {
		return categoryss;
	}

	public void setCategoryss(List<String> categoryss) {
		this.categoryss = categoryss;
	}

	public void reset() {
		RequestContext.getCurrentInstance().reset("form:panel");
	}

	// persist product and image in
	public void save() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
		Store store = storeserv.findStoreById(1);
		Subcategory subcategory = subcategoryserv.findSubCategoryById(1);
		Product p = new Product(buyPrice, expDate, libelle, qte, criticalZone, sellPrice, state, tag, tax, store,
				subcategory);
		indicators.addProduct(p);
		indicators.insertImage(p.getIdProduct(), imgPath);
	}

}