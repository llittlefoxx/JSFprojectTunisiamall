package edu.tunisiamall.subCategoriesServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Subcategory;

@Stateless
public class SubCategoriesServices implements SubCategoriesServicesRemote, SubCategoriesServicesLocal {

	@PersistenceContext
	EntityManager em;

	public SubCategoriesServices() {
	}

	@Override
	public void deleteSubCategories(int idSubCategory) {
		em.remove(findSubCategoryById(idSubCategory));

	}

	@Override
	public List<Subcategory> findAll() {
		Query query = em.createNamedQuery("Subcategory.findAll");
		return query.getResultList();
	}


	@Override
	public Subcategory findSubCategoryById(int idSubCategory) {
		return em.find(Subcategory.class, idSubCategory);
	}

	@Override
	public void addSubCategory(Subcategory subcategory) {
		em.persist(subcategory);

	}

	@Override
	public List<Subcategory> findSubCategoryByIdCategory(int idCategory) {
		
		String queryText = "Select Sub from Subcategory Sub where Sub.category.idCategory = :xxx";
		Query query = em.createQuery(queryText)
				.setParameter("xxx", idCategory);
		return query.getResultList();
	}

}
