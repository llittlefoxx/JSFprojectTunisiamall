package edu.tunisiamall.biservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;

import edu.tunisiamall.categorieServices.CategoryServicesLocal;
import edu.tunisiamall.entities.AnonimousRating;
import edu.tunisiamall.entities.Image;
import edu.tunisiamall.entities.Order;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.PromotionSuggest;
import edu.tunisiamall.entities.Store;

/**
 * Session Bean implementation class IndicatorsService
 */
@Stateless
public class IndicatorsService implements IndicatorsServiceRemote,IndicatorsServiceLocal {

	/**
	 * Default constructor.
	 */
	@EJB
	private CategoryServicesLocal categoryServicesLocal;

	@PersistenceContext
	EntityManager em;

	public IndicatorsService() {
	}

	@Override
	public List<Product> getAllProducts() {
		Query query = em.createNamedQuery("Product.findAll");
		return query.getResultList();
	}

	@Override
	public List<Product> getAllPromotionProducts() {
		Query query = em.createQuery("select p from Product p where p.Promotion IS NOT NULL");
		return query.getResultList();
	}

	@Override
	public HashMap<Product, Integer> getHotProducts() {

		HashMap<Product, Integer> result = new HashMap<Product, Integer>();
		Product product = new Product();
		List<Object[]> itemsList = (ArrayList<Object[]>) em
				.createNativeQuery(
						"select product.idProduct ,sum(orderline.qte) from product ,orderline where product.idProduct=orderline.idProduct_fk group by orderline.idProduct_fk")
				.getResultList();

		for (Object[] objects : itemsList) {
			int id = Integer.parseInt((objects[0]).toString());
			product = categoryServicesLocal.findProductById(id);
			int qte = Integer.parseInt((objects[1]).toString());
			result.put(product, qte);

			System.out.println("produit : " + product.getLibelle() + " Sells qte: " + qte);
		}
		return result;
	}

	@Override
	public Map<String, Double> getMonthlyIncome() {

		return null;
	}

	@Override
	public void CreateReport(String name, String mesure, Date startDate, Date endDate) {

	}

	@Override
	public void DeleteReport(String name) {

	}

	@Override
	public void createPromotionSuggest(PromotionSuggest promotionSuggest) {
		em.persist(promotionSuggest);
	}

	@Override
	public void deletePromotionSuggest(int idPromotionSuggest) {
		List<Product> listP = new ArrayList<Product>();

		listP = getProductsByPromotionSugg(idPromotionSuggest);

		System.out.println(listP.size());
		for (Product product : listP) {
			product.setPromotionSuggest(null);
			categoryServicesLocal.updateProduct(product);
		}

		em.remove(findPromotionSuggestById(idPromotionSuggest));

	}

	@Override
	public void editPromotionSuggest(PromotionSuggest promotionSuggest) {
		em.merge(promotionSuggest);

	}

	@Override
	public List<PromotionSuggest> getAllPromotionSuggest() {
		Query query = em.createNamedQuery("PromotionSuggest.findAll");
		return query.getResultList();
	}

	@Override
	public PromotionSuggest findPromotionSuggestById(int id) {
		return em.find(PromotionSuggest.class, id);
	}

	@Override
	public void affectPromotionSuggestToProduct(int idpr, int idsugg) {
		Product p = new Product();
		p = categoryServicesLocal.findProductById(idpr);
		PromotionSuggest prs = new PromotionSuggest();

		prs = findPromotionSuggestById(idsugg);
		// prs.getProducts().add(p);
		p.setPromotionSuggest(prs);
		categoryServicesLocal.updateProduct(p);
	}

	@Override
	public List<Product> getProductsByPromotionSugg(int idSugP) {
		 Query query = em.createQuery("select p from Product p where p.promotionSuggest.idPromotionSuggest = :idSugP")
		 .setParameter("idSugP", idSugP);
		return query.getResultList();
	}

	@Override
	public void removePromotionSuggestFromProduct(int idproduct) {
		Product product = new Product();
		product = categoryServicesLocal.findProductById(idproduct);
		product.setPromotionSuggest(null);
		categoryServicesLocal.updateProduct(product);

	}

	@Override
	public List<Product> findProductByLib(String lib) {

		Query query = em.createQuery("Select p from Product p where p.libelle like :lib");
		query.setParameter("lib", "%" + lib + "%");

		return query.getResultList();
	}

	@Override
	public List<PromotionSuggest> findPromotionSuggestByName(String name) {
		Query query = em.createQuery("select p from PromotionSuggest p where p.name like :name");
		query.setParameter("name", "%" + name + "%");

		return query.getResultList();
	}

	@Override
	public Product findProductById(int id) {

		return categoryServicesLocal.findProductById(id);
	}

	@Override
	public PromotionSuggest findPromotionSuggestByIdProd(int idProd) {

		Product p = new Product();
		p = findProductById(idProd);
		Query query = em.createQuery("select promotionSuggest from Product p where p.idProduct =:id");
		query.setParameter("id", idProd);
		PromotionSuggest pros = new PromotionSuggest();

		try {
			pros = (PromotionSuggest) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("vide");
		}

		return pros;
	}

	@Override
	public Promotion findPromotionById(Long idprom) {

		return em.find(Promotion.class, idprom);
	}

	@Override
	public Store findStoreById(int idStore) {

		return em.find(Store.class, idStore);
	}

	@Override
	public HashMap<Store, Promotion> getPromotionByStore() {
		HashMap<Store, Promotion> res = new HashMap<Store, Promotion>();
		Query query = em.createNativeQuery(
				"select promotion.idPromotion , store.idStroe from store, promotion where promotion.idPromotion in (select product.Promotion_idPromotion from product) group by store.idStroe");
		List<Object[]> itemsList = (ArrayList<Object[]>) query.getResultList();
		Promotion p = new Promotion();
		Store s = new Store();
		for (Object[] objects : itemsList) {
			Long idProm = Long.parseLong((objects[0]).toString());
			System.out.println("id promo " + idProm);
			p = findPromotionById(idProm);
			System.out.println(p.getName());
			int idStor = Integer.parseInt((objects[1]).toString());
			s = findStoreById(idStor);
			System.out.println("id store " + idStor);
			res.put(s, p);
		}

		return res;
	}

	@Override
	public HashMap<Store, Double> getTopSellingStores() {

		HashMap<Store, Double> res = new HashMap<Store, Double>();
		Query query = em.createNativeQuery(
				"select product.idProduct ,product." + "Promotion_idPromotion, sum(product.sellPrice), "
						+ "sum(product.buyPrice), sum(orderline.qte) , product.tax "
						+ ",product.store_idStroe from product ,orderline where product.idProduct="
						+ "orderline.idProduct_fk group by product.store_idStroe");

		List<Object[]> itemsList = (ArrayList<Object[]>) query.getResultList();

		Store store = new Store();

		double totalbenefProdActuel;

		for (Object[] objects : itemsList) {
			store = findStoreById(Integer.parseInt(objects[6].toString()));
			totalbenefProdActuel = getNetGainPercentage(Double.parseDouble(objects[3].toString()),
					Double.parseDouble(objects[2].toString()), Double.parseDouble(objects[5].toString()))
					* Integer.parseInt(objects[4].toString());
			if (objects[1] != null) {
				totalbenefProdActuel = totalbenefProdActuel - (totalbenefProdActuel
						* (findPromotionById(Long.parseLong(objects[1].toString())).getValue()) / 100);

			}
			res.put(store, totalbenefProdActuel);

		}

		System.out.println("step final: " + res.size());
		return res;
	}

	@Override
	public double getTotalIncome() {
		Query query = em.createNativeQuery("select product.idProduct ,product.Promotion_idPromotion, "
				+ "sum(product.sellPrice), sum(product.buyPrice), sum(orderline.qte) , product."
				+ "tax from product ,orderline " + "where product.idProduct=orderline."
				+ "idProduct_fk group by orderline.idProduct_fk");
		System.out.println("step0");
		List<Object[]> itemsList = (ArrayList<Object[]>) query.getResultList();
		System.out.println("stap 1 sizeee : " + itemsList.size());
		double totalBenefAllProducts = 0;
		double totalbenefProdActuel;
		System.out.println("step2");
		for (Object[] objects : itemsList) {
			totalbenefProdActuel = getNetGainPercentage(Double.parseDouble(objects[3].toString()),
					Double.parseDouble(objects[2].toString()), Double.parseDouble(objects[5].toString()))
					* Integer.parseInt(objects[4].toString());
			if (objects[1] != null) {
				System.out.println("totalbenefProdActuel *" + totalbenefProdActuel);
				totalbenefProdActuel = totalbenefProdActuel - (totalbenefProdActuel
						* (findPromotionById(Long.parseLong(objects[1].toString())).getValue()) / 100);
				System.out.println("totalbenefProdActuel " + totalbenefProdActuel);
			}
			totalBenefAllProducts = totalBenefAllProducts + totalbenefProdActuel;

		}

		System.out.println("step 3 : " + totalBenefAllProducts);
		return totalBenefAllProducts;
	}

	@Override
	public double getNetGainPercentage(double buyPrice, double sellPrice, double tax) {
		double brut = (sellPrice - buyPrice) / buyPrice * 100;
		double net = 0;
		if (tax != 0)
			net = brut * tax / 100;
		else
			net = brut;
		return net;
	}

	@Override
	public List<Image> getImagesByProduct(int id) {
		Query query=em.createQuery("select i from Image i where i.product.idProduct=:id").setParameter("id", id);
		
		return query.getResultList();
	}
@Override
public void rateProduct(AnonimousRating an){
	Date date=new Date();
	an.setDate(date);
	em.persist(an);
}

@Override
public void createPromotion(Promotion promotion) {
	em.persist(promotion);
	
}
}
