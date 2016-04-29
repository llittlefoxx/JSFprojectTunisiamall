package edu.tunisiamall.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "OrderLine.findAll", query = "SELECT o FROM OrderLine o")
public class OrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOrderLine;

	private int qte;

	@ManyToOne
	@JoinColumn(name = "idOrder_fk")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "idProduct_fk")
	private Product product;

	public OrderLine() {
	}

	public int getIdOrderLine() {
		return idOrderLine;
	}

	public void setIdOrderLine(int idOrderLine) {
		this.idOrderLine = idOrderLine;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}