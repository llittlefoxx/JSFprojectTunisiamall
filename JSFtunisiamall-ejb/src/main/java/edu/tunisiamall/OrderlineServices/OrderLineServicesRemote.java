package edu.tunisiamall.OrderlineServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.OrderLine;
import edu.tunisiamall.entities.Product;

@Remote
public interface OrderLineServicesRemote {

	public List<OrderLine> allOrderLineByStore(int idStore);
	public List<OrderLine> findOrderLineBydate(int idStore, Date date);
	public List<Product> getAllProductfromOrder(int idStore);
	public boolean verifyDisponibility(int idStore);
	public OrderLine findOrdeline(int idOrderLine);
	public List<Product> getAllProductByStore(int idStore);
}
