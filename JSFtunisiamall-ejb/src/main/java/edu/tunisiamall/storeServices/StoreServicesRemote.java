package edu.tunisiamall.storeServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Mvtstock;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Store;

@Remote
public interface StoreServicesRemote {

	public Store addStore(Store store);
	public void deleteStore(int idStore);
	public Store updateStore(int idStore);
	public Store findStoreById(Integer id);
	public List<Store> findAllSStoreByCategory(String libelle);
	public List<Store> findAllSStore();
	public List<Store> findStoreByShopOwner(int shopownerId);
	public List<Product> findStockProdByIdStore(int idStore);
	public Mvtstock addMvtStock(Mvtstock stock);
	public List<Mvtstock> getAllMvtStock();
	public Mvtstock findMvtstockById(int id);

	
}
