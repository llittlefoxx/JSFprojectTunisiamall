package edu.tunisiamall.subCategoriesServices;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Subcategory;

@Local
public interface SubCategoriesServicesLocal {
	public void addSubCategory(Subcategory subcategory);

	public void deleteSubCategories(int idSubCategory);

	public Subcategory findSubCategoryById(int idSubCategory);

	public List<Subcategory> findAll();

	public List<Subcategory> findSubCategoryByIdCategory(int idCategory);
	
	public void saveSubcategory(Subcategory subcategory);
}
