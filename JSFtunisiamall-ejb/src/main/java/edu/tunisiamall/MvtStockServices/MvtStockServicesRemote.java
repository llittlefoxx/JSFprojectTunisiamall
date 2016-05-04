package edu.tunisiamall.MvtStockServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Mvtstock;
import edu.tunisiamall.entities.Product;

@Remote
public interface MvtStockServicesRemote {

	
	public List<Mvtstock> allMyMvtStock(int idStore);
	
	public List<Mvtstock> findMyMvtStockByDate(int idStore, Date date);
	
	public List<Mvtstock> findMyMvtStockByProduct(int idStore,int idProd);
	
	public void addMvtStock(Mvtstock stock);
	
	public Mvtstock getMvtStock(int idstock);
	
	public void updateQuantityProductAfterMvtStock(int idProd, int idMvtStock);
	
	public Product findProductByIdString(int id);
}
