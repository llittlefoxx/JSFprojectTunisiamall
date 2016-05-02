package edu.tunisiamall.beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.tunisiamall.categorieServices.CategoryServicesLocal;
import edu.tunisiamall.entities.*;
import edu.tunisiamall.subCategoriesServices.*;

@ManagedBean
@SessionScoped
public class SubCategoriesBean {
	List<Subcategory> Subcategories;

	public List<Subcategory> getSubcategories() {
		return Subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		Subcategories = subcategories;
	}

	Subcategory subcategory;
	//private int idSubcategory;

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}
    List<Category> categories;
    
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@EJB
	SubCategoriesServicesLocal subcategoryService;
	
	@EJB
	CategoryServicesLocal categoryService;

	@PostConstruct
	public void init() {
		Subcategories = subcategoryService.findAll();
		subcategory = new Subcategory();
		subcategory.setCategory(new Category());
	}
	public String doselect(int idSubcategory){
		String navigateTo = "/SubCategories/UpdateSubCategory?faces-redirect=true";
		subcategory = subcategoryService.findSubCategoryById(idSubcategory);
		return navigateTo; 
	}
	public void doAdd(){
		subcategoryService.addSubCategory(subcategory);
		Subcategories = subcategoryService.findAll();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("SubcategoriesList.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void doDelete(int idSubcategory){
		subcategoryService.deleteSubCategories(idSubcategory);
		Subcategories = subcategoryService.findAll();
	}
	public void doUpdate(Subcategory subcategory){
		subcategoryService.saveSubcategory(subcategory);
		Subcategories = subcategoryService.findAll();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("SubcategoriesList.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Category> ListCategories(){
		return categories = categoryService.findAll();
	}
}
