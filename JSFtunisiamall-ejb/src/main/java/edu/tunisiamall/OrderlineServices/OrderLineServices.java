package edu.tunisiamall.OrderlineServices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.MvtStockServices.MvtStockServicesLocal;
import edu.tunisiamall.entities.Mvtstock;
import edu.tunisiamall.entities.OrderLine;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesLocal;

/**
 * Session Bean implementation class OrderLineServices
 */
@Stateless
@LocalBean
public class OrderLineServices implements OrderLineServicesRemote, OrderLineServicesLocal {

	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	StoreServicesLocal storelocal;
	MvtStockServicesLocal mvtstocklocal;
    /**
     * Default constructor. 
     */
    public OrderLineServices() {
        // TODO Auto-generated constructor stub
    }

    
    
	@Override
	public List<OrderLine> allOrderLineByStore(int idStore) {
		System.out.println("hhhhh 1111");
		Store st= storelocal.findStoreById(idStore);
		System.out.println("hhhhh "+ st.getName());
		Query query = em.createQuery("select ol from OrderLine ol where ol.product.store=:id").setParameter("id", st);
		return query.getResultList();
	
	}

	@Override
	public List<OrderLine> findOrderLineBydate(int idStore, Date date) {
		List<OrderLine> listdate = new ArrayList<OrderLine>();
		List<OrderLine> listdate2 = new ArrayList<OrderLine>();
		Calendar cal2 = Calendar.getInstance(); 
		 int year ;
		    int month ;
		    int day ;
		
		cal2.setTime(date);
		    int year2 = cal2.get(Calendar.YEAR);
		    int month2 = cal2.get(Calendar.MONTH);
		    int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		   
		Store st= storelocal.findStoreById(idStore);
		Query query = em.createQuery("select ol from OrderLine ol where ol.product.store=:id").setParameter("id", st);
		listdate = query.getResultList();
		for(OrderLine ol : listdate)
		{
			
			
			 Date date2 = ol.getOrder().getDate();
			    Calendar cal = Calendar.getInstance();
			   
			    cal.setTime(date2);
			    	year = cal.get(Calendar.YEAR);
			    	month = cal.get(Calendar.MONTH);
			    	day = cal.get(Calendar.DAY_OF_MONTH);
			    
			   
			if(year == year2 && day==day2 && month == month2)
			{
				listdate2.add(ol);
			}
		}
		return listdate2;
		
	}
	
	// Afficher la liste de mes produits avec les quantités
	@Override
	public List<Product> getAllProductByStore(int idStore) {
		Store st= storelocal.findStoreById(idStore);
		Query query = em.createQuery("select p from Product p where p.store=:id").setParameter("id", st);
		return query.getResultList();

	}
	
	
	@Override
	public List<Object[]> getAllProductfromOrder(int idStore) {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();

		Date todayWithZeroTime=null;
		try {
			todayWithZeroTime = formatter.parse(formatter.format(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		    	
		Store st= storelocal.findStoreById(idStore);
		List<Object[]> results = em.createQuery("SELECT ol.product, sum(ol.qte) from OrderLine ol where ol.product.store=:id and ol.order.date > current_date() or ol.order.date = current_date() GROUP BY ol.product ")
				.setParameter("id", st)
		        .getResultList();
		for (Object[] result : results) {
		    Product p = (Product) result[0];
		    System.out.println("pppp "+p.getLibelle());
		    int count = ((Number) result[1]).intValue();
		    System.out.println("qttttt "+count);
		}
		
		return results;
	}

	@Override
	public boolean verifyDisponibility(int idOrderline) {
		OrderLine ol = findOrdeline(idOrderline);
		boolean test= false; 
		if(ol.getQte()> ol.getProduct().getQte())
			{
				System.out.println("Insuffisant quantity");
				
			}
			else 
			{
				System.out.println("Product disponible");
				test = true; 
			}
		
		return test;
	}



	@Override
	public OrderLine findOrdeline(int idOrderLine) {
		return em.find(OrderLine.class, idOrderLine);
	}

	@Override
	public List<OrderLine> triOrderLineBydate(int idStore) {
 
		Store st= storelocal.findStoreById(idStore);
		Query query = em.createQuery("select ol from OrderLine ol where ol.product.store=:id order by ol.order.date desc").setParameter("id", st);
		return query.getResultList();
	
	}



}
