package edu.tunisiamall.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.tunisiamall.MvtStockServices.MvtStockServicesLocal;
import edu.tunisiamall.OrderlineServices.OrderLineServicesLocal;
import edu.tunisiamall.entities.Mvtstock;
import edu.tunisiamall.entities.Product;

@ManagedBean
@SessionScoped 
public class MvtStockBean {

	Mvtstock mvtstock ;
	Mvtstock mvtstockselected ;
	List<Mvtstock> mvtstocks;
	List<Mvtstock> mvtstocksProd;
	List<Mvtstock> mvtstocksProd2;
	public List<Mvtstock> getMvtstocksProd2() {
		return mvtstocksProd2;
	}
	public void setMvtstocksProd2(List<Mvtstock> mvtstocksProd2) {
		this.mvtstocksProd2 = mvtstocksProd2;
	}
	String input;
	Date mvtstockdate;
	
	List<Product> products;
	
	
	Product product;
	
	int ancienqte;
	
	
	
	
	 public int getAncienqte() {
		return ancienqte;
	}
	public void setAncienqte(int ancienqte) {
		this.ancienqte = ancienqte;
	}
	public Date getMvtstockdate() {
		return mvtstockdate;
	}
	public void setMvtstockdate(Date mvtstockdate) {
		this.mvtstockdate = mvtstockdate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManagedProperty(value="#{orderbean}")  
	OrderLineBean orderbean;
	
	 
	 
	
	public OrderLineBean getOrderbean() {
		return orderbean;
	}
	public void setOrderbean(OrderLineBean orderbean) {
		this.orderbean = orderbean;
	}
	public Mvtstock getMvtstockselected() {
		return mvtstockselected;
	}
	public void setMvtstockselected(Mvtstock mvtstockselected) {
		this.mvtstockselected = mvtstockselected;
	}
	public Mvtstock getMvtstock() {
		return mvtstock;
	}
	public void setMvtstock(Mvtstock mvtstock) {
		this.mvtstock = mvtstock;
	}
	public List<Mvtstock> getMvtstocks() {
		return mvtstocks;
	}
	public void setMvtstocks(List<Mvtstock> mvtstocks) {
		this.mvtstocks = mvtstocks;
	}
	public List<Mvtstock> getMvtstocksProd() {
		return mvtstocksProd;
	}
	public void setMvtstocksProd(List<Mvtstock> mvtstocksProd) {
		this.mvtstocksProd = mvtstocksProd;
	}
	// EJB
		@EJB
		MvtStockServicesLocal mvtstockservice;
		
		@EJB
		OrderLineServicesLocal orderlineservice;
		
		
		// init
		@PostConstruct
		public void init() {
		
			mvtstocks=mvtstockservice.allMyMvtStock(2);
			mvtstocksProd= null;
			product=null;
			mvtstock = new Mvtstock();
			products = orderlineservice.getAllProductByStore(2);
			}
	
		
		public void reloadTableProducts()
		{
			if(input==null)
			{
				//mvtstocksProd= mvtstockservice.findMyMvtStockByProduct(2, 4);
			}
			else
			{
				//mvtstocksProd= mvtstockservice.findMyMvtStockByProduct(2, Integer.parseInt(input));
			}
			
		}
		
		public Product selectProduct(Product p)
		{
			product=p;
			System.out.println("ppppprroooodd  "+p.getLibelle());
			return product;
		}
		public void addMvtstockk()
		{
			
			product=mvtstockservice.findProductByIdString(Integer.parseInt(input));
			ancienqte= product.getQte();
			System.out.println("9999999999 "+ product.getLibelle());
			mvtstock.setDate(new Date());
			mvtstock.setProduct(product);
			mvtstockservice.addMvtStock(mvtstock);
			System.out.println("stock before update***** "+ product.getQte());
			mvtstockservice.updateQuantityProductAfterMvtStock(product.getIdProduct(), mvtstock.getIdMvt());
			product = mvtstockservice.findProductByIdString(product.getIdProduct());
			System.out.println("stock update***** "+ product.getQte());
			
			mvtstocksProd=mvtstockservice.findMyMvtStockByProduct(2, Integer.parseInt(input));
			mvtstock = new Mvtstock();
			mvtstocks=mvtstockservice.allMyMvtStock(2);
		}

		
		
		public void selectMvtStock(Mvtstock mvt)
		{
			mvtstock = mvt;
		}
		
		
		
		
		
}
