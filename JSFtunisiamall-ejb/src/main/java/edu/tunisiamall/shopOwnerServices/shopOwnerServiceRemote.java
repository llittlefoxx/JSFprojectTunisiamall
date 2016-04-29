package edu.tunisiamall.shopOwnerServices;

import java.util.List;

import javax.ejb.Remote;


import edu.tunisiamall.entities.Shopowner;


@Remote
public interface shopOwnerServiceRemote {
	public List<Shopowner> findAllSO();	
	void create(Shopowner shopowner);
	public void delete(Shopowner so);
	public long count();
	public List<Shopowner> find(String chaine,String value);
	public void updateShopeOwner(Shopowner sh);
	
}
