package edu.tunisiamall.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.tunisiamall.OrderlineServices.OrderLineServicesLocal;
import edu.tunisiamall.entities.OrderLine;
@ManagedBean
@ViewScoped 
public class OrderLineBean {
	
	List<OrderLine> orderlines;

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
	
	
	// init
	@PostConstruct
	public void init() {
		orderlines = orderlineservice.allOrderLineByStore(2);
		
	}
}
