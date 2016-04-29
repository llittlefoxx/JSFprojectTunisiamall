package edu.tunisiamall.shopRequestServices;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.ShopRequest;

/**
 * Session Bean implementation class ManageShopRequestServices
 */
@Stateless
public class ManageShopRequestServices implements ManageShopRequestServicesRemote, ManageShopRequestServicesLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
	
    public ManageShopRequestServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addShopRequest(ShopRequest srequest) {
		em.persist(srequest);
		
	}

	@Override
	public void deleteShopRequest(ShopRequest srequest) {
		em.remove(em.merge(srequest));
		
	}

	@Override
	public void updateShopRequest(ShopRequest srequest) {
		em.merge(srequest);
		
	}



	@Override
	public List<ShopRequest> findAllShopRequest() {
		Query query = em.createQuery("select s from ShopRequest s ");
		return query.getResultList();
		
	}

	
	@Override
	public ShopRequest findShopRequestById(Integer id) {
		return em.find(ShopRequest.class, id);
		
		 
	}

	@Override
	public List<ShopRequest> findAllShopRequestByCategory(String caegory) {
		return null;
	
	}

	@Override
	public List<ShopRequest> findAllShopRequestUnchecked(){
		
		Query query = em.createQuery("select s from ShopRequest s where s.status is false");
		//query.setParameter("rcptDate", date);
		return query.getResultList();
		
	}

	@Override
	public List<ShopRequest> findAllShopRequestSearchTools(String email, int storeimall) {
		System.out.println("ggggggg "+ email);
		Query query = null;
		if (email != null && storeimall==0)
		{  query = em.createQuery("select s from ShopRequest s where s.email like '%"+email+"%' and storeinmall is false");}
		
		else if(email != null && storeimall==1)
			{
			 query = em.createQuery("select s from ShopRequest s where s.email like'%"+email+"%' and storeinmall is true");
			}
		else if(email != null && storeimall==2)
		{
			 query = em.createQuery("select s from ShopRequest s where s.email like '%"+email+"%' ");
		}
		else if(storeimall==0 && email.equals(""))
		 { query = em.createQuery("select s from ShopRequest s where storeinmall is false");}
		else if (storeimall==1 && email==null)
		{  query = em.createQuery("select s from ShopRequest s where storeinmall is true");}
		
		
	
		return query.getResultList();
	}

	@Override
	public List<ShopRequest> findAllShopRequestByWord(String word) {
		System.out.println("houniiii  ");
		Query query = em.createQuery("select s from ShopRequest s where s.description like '%"+word+"%'");
		//query.setParameter("rcptDate", date);
		return query.getResultList();
	}

	@Override
	public List<ShopRequest> findAllShopRequestByRcptDate(Date date) {
		
		System.out.println("houniiii  ");
		Query query = em.createQuery("select s from ShopRequest s where s.rcptDate=:date")
				.setParameter("date", date);
		//query.setParameter("rcptDate", date);
		return query.getResultList();
	}



}
