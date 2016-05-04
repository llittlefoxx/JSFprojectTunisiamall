package edu.tunisiamall.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import edu.tunisiamall.OrderlineServices.OrderLineServicesLocal;
import edu.tunisiamall.biservices.IndicatorsServiceLocal;
import edu.tunisiamall.entities.Image;
import edu.tunisiamall.entities.Product;

@ManagedBean(name="myprods")
public class MyProductsBean {

	@EJB
	OrderLineServicesLocal olservice;

	@EJB
	IndicatorsServiceLocal indicators;
	
	private Product selectedProduct;
	public MyProductsBean(){
		
	}
	
	public List<Product> getMyproducts(){
		return olservice.getAllProductByStore(1);
	}
	
	public Image getProductImage(int idProd){
		System.out.println("size : " +indicators.getImagesByProduct(idProd).getImagePath());
	return indicators.getImagesByProduct(idProd);
	}

	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Product Selected", ((Product) event.getObject()).getLibelle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	
	
}
