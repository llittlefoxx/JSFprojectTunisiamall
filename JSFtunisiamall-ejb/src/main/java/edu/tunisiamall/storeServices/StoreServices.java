package edu.tunisiamall.storeServices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.categorieServices.CategoryServicesLocal;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Mvtstock;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.userServices.userServicesLocal;

/**
 * Session Bean implementation class StoreServices
 */
@Stateless
public class StoreServices implements StoreServicesRemote, StoreServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
	@EJB
	CategoryServicesLocal catlocal;
	

	@EJB
	userServicesLocal userlocal;
    public StoreServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Store addStore(Store store) {
		 em.persist(store);
		 return store;
	}

	@Override
	public void deleteStore(int idStore) {
		Store s = findStoreById(idStore);
		em.remove(s);
		
	}

	@Override
	public Store updateStore(int idStore) {
		Store s =em.find(Store.class, idStore);
		return em.merge(s);
		
	}

	@Override
	public Store findStoreById(Integer id) {
		return em.find(Store.class, id);
	}
	@Override
	public List<Store> findAllSStoreByCategory(String libelle) {
		Category cat= catlocal.SearchCategory2(libelle);
		Query query=em.createQuery("select st from Store st where st.category=:id")
				.setParameter("id", cat);
		return query.getResultList();
	}
	
	@Override
	public List<Store> findAllSStore() {
		Query query=em.createQuery("select st from Store st ");
		return query.getResultList();
	}
	@Override
	public List<Store> findStoreByShopOwner(int shopownerId) {
		Shopowner sh = (Shopowner) userlocal.findShopOwnerById(shopownerId);
		System.out.println("hhhhh "+ sh.getIdUser());
		Query query=em.createQuery("select st from Store st where st.shopowner=:id")
				.setParameter("id", sh);
		return query.getResultList();
		
		
	
	}

	@Override
	public List<Product> findStockProdByIdStore(int idStore) {
		Store s = findStoreById(idStore);
		
		Query query=em.createQuery("select p from Product p where p.store=:id")
				.setParameter("id", s);
		List<Product> l =query.getResultList();
		List<Product> l2=new ArrayList<Product>();
		for (Product p :l )
		{
			Product p1 = new Product(p.getIdProduct(), p.getLibelle(), p.getQte(), p.getStore());
			l2.add(p1);
		}
		return l2;
	}

	@Override
	public Mvtstock addMvtStock(Mvtstock stock) {
		
		em.persist(stock);
		return stock;
	}

	@Override
	public List<Mvtstock> getAllMvtStock() {
	
		Query query=em.createQuery("select mvt from Mvtstock mvt");
			
		return query.getResultList();
	}

	@Override
	public Mvtstock findMvtstockById(int id) {
		return em.find(Mvtstock.class, id);
	}

	

}
