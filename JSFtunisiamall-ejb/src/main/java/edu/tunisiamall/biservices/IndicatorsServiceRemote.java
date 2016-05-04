package edu.tunisiamall.biservices;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.PromotionSuggest;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.util.Stat;

@Remote
public interface IndicatorsServiceRemote {

	// indicators
	public double getNetGainPercentage(double buyPrice, double sellPrice, double tax);
	
	public List<Product> getAllProducts();

	public List<Product> getAllPromotionProducts();

	public HashMap<Product, Integer> getHotProducts();

	public HashMap<Store,Double> getTopSellingStores();
	
	public double getTotalIncome();
	
	public List<Stat> getMonthlyIncome();

	public List<Product> findProductByLib(String lib);

	public Product findProductById(int id);

	public HashMap<Store, Promotion> getPromotionByStore();

	public Promotion findPromotionById(Long idprom);

	public Store findStoreById(int idStore);

	// report

	public void CreateReport(String name, String mesure, Date startDate, Date endDate);

	public void DeleteReport(String name);

	// promotionsSuggest

	public void createPromotionSuggest(PromotionSuggest promotionSuggest);

	public void deletePromotionSuggest(int idPromotionSuggest);

	public void editPromotionSuggest(PromotionSuggest promotionSuggest);

	public List<PromotionSuggest> getAllPromotionSuggest();

	public PromotionSuggest findPromotionSuggestById(int id);

	public List<PromotionSuggest> findPromotionSuggestByName(String name);

	public void affectPromotionSuggestToProduct(int prod, int prom);

	public void removePromotionSuggestFromProduct(int idproduct);

	public List<Product> getProductsByPromotionSugg(int idSugP);

	public PromotionSuggest findPromotionSuggestByIdProd(int idProd);
	
	public void createPromotion(Promotion promotion);
}
