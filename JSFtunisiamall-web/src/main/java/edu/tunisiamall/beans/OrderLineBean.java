package edu.tunisiamall.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;

import edu.tunisiamall.OrderlineServices.OrderLineServicesLocal;
import edu.tunisiamall.entities.OrderLine;
import edu.tunisiamall.entities.Product;
@ManagedBean
@ViewScoped 
public class OrderLineBean {
	
	List<OrderLine> orderlines;
	List<OrderLine> orderlinesRecents;
	List<Product> produits;
	
	List<Object[]> produitsFromOrders;
	

	
	
	public List<Object[]> getProduitsFromOrders() {
		return produitsFromOrders;
	}

	public void setProduitsFromOrders(List<Object[]> produitsFromOrders) {
		this.produitsFromOrders = produitsFromOrders;
	}

	public List<Product> getProduits() {
		return produits;
	}

	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}

	public List<OrderLine> getOrderlinesRecents() {
		return orderlinesRecents;
	}

	public void setOrderlinesRecents(List<OrderLine> orderlinesRecents) {
		this.orderlinesRecents = orderlinesRecents;
	}

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	
	OrderLine orderline = new OrderLine();

	public OrderLine getOrderline() {
		return orderline;
	}

	public void setOrderline(OrderLine orderline) {
		this.orderline = orderline;
	}

	// EJB
	@EJB
	OrderLineServicesLocal orderlineservice;
	
	
	public  Date toDate(){
		Date today = new Date();
		return today;
	}

	 
	

	// init
	@PostConstruct
	public void init() {
		orderlines = orderlineservice.allOrderLineByStore(2);
		orderlinesRecents = orderlineservice.triOrderLineBydate(2);
		produits = orderlineservice.getAllProductByStore(2);
		produitsFromOrders = orderlineservice.getAllProductfromOrder(2);
		for (Object[] result : produitsFromOrders) {
		    Product p = (Product) result[0];
		    System.out.println("pppp "+p.getLibelle());
		    int count = ((Number) result[1]).intValue();
		    System.out.println("qttttt "+count);
		}
	
	
	
	}
	

}
