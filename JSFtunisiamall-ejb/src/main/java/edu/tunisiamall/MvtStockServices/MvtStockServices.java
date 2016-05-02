package edu.tunisiamall.MvtStockServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Mvtstock;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesLocal;

/**
 * Session Bean implementation class MvtStockServices
 */
@Stateless
@LocalBean
public class MvtStockServices implements MvtStockServicesRemote, MvtStockServicesLocal {

	@PersistenceContext
	EntityManager em;
	
	@EJB
	StoreServicesLocal storelocal;
    /**
     * Default constructor. 
     */
    public MvtStockServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Mvtstock> allMyMvtStock(int idStore) {
		Store st= storelocal.findStoreById(idStore);
		System.out.println("sssss "+ st.getName());
		Query query = em.createQuery("select mvt from Mvtstock mvt where mvt.product.store=:id").setParameter("id", st);
		return query.getResultList();
	
	}

	@Override
	public List<Mvtstock> findMyMvtStockByDate(int idStore, Date date) {
		List<Mvtstock> mvtstockList = allMyMvtStock(idStore);
		List<Mvtstock> listVide = new ArrayList<>();
		for(Mvtstock mv:mvtstockList )
		{
			if(mv.getDate()== date)
			{
				listVide.add(mv);
			}
		}
		return listVide;
	}

	@Override
	public List<Mvtstock> findMyMvtStockByProduct(int idStore, int idProd) {
		Store st= storelocal.findStoreById(idStore);
		Query query1 = em.createQuery("select p from Product p where p.idProduct=:id").setParameter("id", idProd);
		Product prod = (Product) query1.getSingleResult();
		Query query = em.createQuery("select mvt from Mvtstock mvt where mvt.product.store=:id and mvt.product=:id2").setParameter("id", st).setParameter("id2", prod);
		return query.getResultList();
		
	}

	@Override
	public void addMvtStock(Mvtstock stock) {
		em.persist(stock);
		
	}

	@Override
	public Mvtstock getMvtStock(int idstock) {
		
		return em.find(Mvtstock.class, idstock);
	}

	@Override
	public void updateQuantityProductAfterMvtStock(int idProd, int idMvtStock) {
		
		Mvtstock mvt = getMvtStock(idMvtStock);
		System.out.println("dans update: valeur stock ajoute ****  "+ mvt.getQte());
		Product prod= mvt.getProduct();
		System.out.println("dans update: valeur qte prod avant  ****  "+ prod.getQte());
		prod.setQte(prod.getQte()+mvt.getQte());
		em.merge(em.find(Product.class, prod.getIdProduct()));
		System.out.println("fin update: valeur qte prod apres  ****  "+ prod.getQte());
	}

	@Override
	public Product findProductByIdString(int id) {
		return em.find(Product.class, id);
		
	}

}
