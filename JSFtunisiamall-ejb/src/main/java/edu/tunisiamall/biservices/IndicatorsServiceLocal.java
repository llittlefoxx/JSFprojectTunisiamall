package edu.tunisiamall.biservices;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.AnonimousRating;
import edu.tunisiamall.entities.Image;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.Store;

@Local
public interface IndicatorsServiceLocal {
	public List<Product> getAllProducts();
	public HashMap<Product, Integer> getHotProducts();
	public List<Product> findProductByLib(String lib);
	public HashMap<Store, Promotion> getPromotionByStore();
	public List<Image> getImagesByProduct(int id);
	public void rateProduct(AnonimousRating ar);
}
