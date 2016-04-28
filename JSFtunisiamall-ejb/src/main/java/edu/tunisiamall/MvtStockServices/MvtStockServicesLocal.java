package edu.tunisiamall.MvtStockServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import edu.tunisiamall.entities.Mvtstock;
@Local
public interface MvtStockServicesLocal {

	public List<Mvtstock> allMyMvtStock(int idStore);
	public List<Mvtstock> findMyMvtStockByDate(int idStore, Date date);
	public List<Mvtstock> findMyMvtStockByProduct(int idStore,int idProd);
	public void addMvtStock(Mvtstock stock);
	public Mvtstock getMvtStock(int idstock);
	public void updateQuantityProductAfterMvtStock(int idProd, int idMvtStock);
	
	
	
	
}
