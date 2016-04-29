package edu.tunisiamall.subCategoriesServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Subcategory;

@Remote
public interface SubCategoriesServicesRemote {
	public void addSubCategory(Subcategory subcategory);

	public void deleteSubCategories(int idSubCategory);

	public Subcategory findSubCategoryById(int idSubCategory);

	public List<Subcategory> findAll();

	public List<Subcategory> findSubCategoryByIdCategory(int idCategory);

}
