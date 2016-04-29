package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Customer")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String facturationAddr;

	private String shipementAddr;

	public Customer() {
	}

	public String getFacturationAddr() {
		return facturationAddr;
	}

	public void setFacturationAddr(String facturationAddr) {
		this.facturationAddr = facturationAddr;
	}

	public String getShipementAddr() {
		return shipementAddr;
	}

	public void setShipementAddr(String shipementAddr) {
		this.shipementAddr = shipementAddr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}