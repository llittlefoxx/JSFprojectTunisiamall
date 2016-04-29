package edu.tunisiamall.OrderlineServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		Store st= storelocal.findStoreById(idStore);
		Query query = em.createQuery("select ol from OrderLine ol where ol.store=:id").setParameter("id", st);
		listdate = query.getResultList();
		for(OrderLine ol : listdate)
		{
			if(ol.getOrder().getDate()==date)
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
	public List<Product> getAllProductfromOrder(int idStore) {
		
		List<OrderLine> list1 = new ArrayList<>();
		List<Product> list2 = new ArrayList<>();
		list1 = allOrderLineByStore(idStore);
		for(OrderLine ol : list1)
		{
			list2.add(ol.getProduct());
		}
		return list2;
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



}
