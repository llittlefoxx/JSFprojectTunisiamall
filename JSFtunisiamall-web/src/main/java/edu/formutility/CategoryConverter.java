package edu.formutility;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.tunisiamall.categorieServices.CategoryServicesLocal;
import edu.tunisiamall.entities.Category;

@ManagedBean(name = "categoryConverterBean") 	
@FacesConverter(value = "categoryConverter")
public class CategoryConverter implements Converter {

	@EJB
	CategoryServicesLocal categoryServices;
	
	public static Category currentcat;
	
	public Category getCurrentcat() {
		return currentcat;
	}

	

	public CategoryConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		System.out.println("cat "+value);
		currentcat= categoryServices.findCategoryByName(value);
		return currentcat;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		// TODO Auto-generated method stub
		return ((Category) categoryServices.findCategoryByName(o.toString())).getLibelle();
	}

}
