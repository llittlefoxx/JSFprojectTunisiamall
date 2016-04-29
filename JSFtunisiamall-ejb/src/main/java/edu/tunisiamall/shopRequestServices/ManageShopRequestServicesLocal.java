package edu.tunisiamall.shopRequestServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.ShopRequest;

@Local
public interface ManageShopRequestServicesLocal {

	public void addShopRequest(ShopRequest srequest);
	public void deleteShopRequest(ShopRequest srequest);
	public void updateShopRequest(ShopRequest srequest);
	public ShopRequest findShopRequestById(Integer id);
	public List<ShopRequest> findAllShopRequest();
	public List<ShopRequest> findAllShopRequestByCategory(String caegory);
	public List<ShopRequest> findAllShopRequestUnchecked();
	public List<ShopRequest> findAllShopRequestByRcptDate(Date date);
	public List<ShopRequest> findAllShopRequestSearchTools(String email, int storeimall);
	public List<ShopRequest> findAllShopRequestByWord(String word);
}
