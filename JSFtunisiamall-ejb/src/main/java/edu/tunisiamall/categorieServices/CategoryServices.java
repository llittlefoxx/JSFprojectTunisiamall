package edu.tunisiamall.categorieServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Subcategory;

/**
 * Session Bean implementation class CategoryServices
 */
@Stateless
public class CategoryServices implements CategoryServicesRemote, CategoryServicesLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public CategoryServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCategory(Category category) {

		em.persist(category);
		System.out.println(category.getIdCategory());
	}

	@Override
	public void updateCategroy(Category c) {
		// TODO Auto-generated method stub
		em.merge(c);

	}

	@Override
	public void deleteCategory(Category c) {
		em.remove(em.merge(c));
	}

	@Override
	public Category findCategoryById(int idCategory) {
		// TODO Auto-generated method stub
		return em.find(Category.class, idCategory);
	}


	@Override
	public List<Category> findAll() {
		Query query = em.createQuery("select c from Category c");
		return query.getResultList();
	}

	@Override
	public List<Category> SearchCategory(String L) {
		
		Query query = em.createQuery("select c from Category c where c.libelle like :Name").setParameter("Name","%" + L + "%");
		return query.getResultList();

	}

	@Override
	public void addProduct(Product product) {

		em.persist(product);

	}

	@Override
	public void addSubCategory(Subcategory subcategory) {

		em.persist(subcategory);

	}

	@Override
	public Category findCategoryByName(String name) {
		Query query = em.createQuery("select c from Category c where c.libelle like :Name").setParameter("Name", name);

		return (Category) query.getSingleResult();
	}

	@Override
	public Subcategory findSubCatByName(String name) {
		Query query = em.createQuery("select c from Subcategory c where c.libelle like :Name").setParameter("Name",
				name);

		return (Subcategory) query.getSingleResult();
	}

	@Override
	public Product findProductById(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public void updateProduct(Product product) {
		em.merge(product);
	}

	@Override
	public Category SearchCategory2(String L) {
		// TODO Auto-generated method stub
		//String queryText = 
		Query query = em.createQuery("select c from Category c where c.libelle=:name")
				.setParameter("name",L);
		return (Category) query.getSingleResult();
		
	}


}
