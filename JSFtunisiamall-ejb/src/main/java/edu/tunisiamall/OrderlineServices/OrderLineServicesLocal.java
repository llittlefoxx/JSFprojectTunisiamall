package edu.tunisiamall.OrderlineServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.OrderLine;
import edu.tunisiamall.entities.Product;

@Local
public interface OrderLineServicesLocal {

	
	public List<OrderLine> allOrderLineByStore(int idStore);
	public List<OrderLine> findOrderLineBydate(int idStore, Date date);
	public List<Product> getAllProductfromOrder(int idStore);
	public List<Product> getAllProductByStore(int idStore);
	public OrderLine findOrdeline(int idOrderLine);
	public boolean verifyDisponibility(int idOrderline);


}
