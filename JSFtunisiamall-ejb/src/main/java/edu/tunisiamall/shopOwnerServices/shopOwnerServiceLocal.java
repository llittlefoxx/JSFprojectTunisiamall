package edu.tunisiamall.shopOwnerServices;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Shopowner;

@Local
public interface shopOwnerServiceLocal {
	public List<Shopowner> findAllSO();
	public void updateShopeOwner(Shopowner sh);
	void create(Shopowner shopowner);
	public long count();
	public List<Shopowner> find(String chaine,String value);
	public void delete(Shopowner so);

}
