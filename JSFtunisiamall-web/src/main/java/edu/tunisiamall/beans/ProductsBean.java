package edu.tunisiamall.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import edu.tunisiamall.biservices.IndicatorsServiceLocal;
import edu.tunisiamall.entities.Image;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.storeServices.StoreServicesLocal;

@ManagedBean(name = "pbean")
@ViewScoped
public class ProductsBean {

	@EJB
	IndicatorsServiceLocal indicators;

	@EJB
	StoreServicesLocal storeService;

	private Product selectedProduct;

	public ProductsBean() {
	}

	public List<Product> getAllProds() {
		return indicators.getAllProducts();
	}

	public Image getProductImage(int idProd) {
		System.out.println("size : " + indicators.getImagesByProduct(idProd).getImagePath());
		return indicators.getImagesByProduct(idProd);
	}

	// delete product and related image

	public void deleteProduct(int id) {
		indicators.deleteProd(id);

	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Product Selected", ((Product) event.getObject()).getLibelle());
		setSelectedProduct((Product) event.getObject());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
