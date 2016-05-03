package edu.tunisiamall.beans;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import edu.tunisiamall.MvtStockServices.MvtStockServicesLocal;
import edu.tunisiamall.OrderlineServices.OrderLineServicesLocal;
import edu.tunisiamall.entities.OrderLine;
import edu.tunisiamall.entities.Product;
@ManagedBean
@SessionScoped 
public class OrderLineBean {
	
	List<OrderLine> orderlines;
	List<OrderLine> orderlinesRecents;
	List<Product> produits;
	private OrderLine selectedOrderLine;
	List<Object[]> produitsFromOrders;

	private Product selectedProduct;
	
	private Product productParam;


	
	
	public Product getProductParam() {
		return productParam;
	}

	public void setProductParam(Product productParam) {
		this.productParam = productParam;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public OrderLine getSelectedOrderLine() {
		return selectedOrderLine;
	}

	public void setSelectedOrderLine(OrderLine selectedOrderLine) {
		this.selectedOrderLine = selectedOrderLine;
	}

	public List<Object[]> getProduitsFromOrders() {
		return produitsFromOrders;
	}

	public void setProduitsFromOrders(List<Object[]> produitsFromOrders) {
		this.produitsFromOrders = produitsFromOrders;
	}

	public List<Product> getProduits() {
		return produits;
	}

	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}

	public List<OrderLine> getOrderlinesRecents() {
		return orderlinesRecents;
	}

	public void setOrderlinesRecents(List<OrderLine> orderlinesRecents) {
		this.orderlinesRecents = orderlinesRecents;
	}

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	
	OrderLine orderline = new OrderLine();

	public OrderLine getOrderline() {
		return orderline;
	}

	public void setOrderline(OrderLine orderline) {
		this.orderline = orderline;
	}

	// EJB
	@EJB
	OrderLineServicesLocal orderlineservice;
	@EJB
	MvtStockServicesLocal mvtstockservice;
	
	public  Date toDate(){
		Date today = new Date();
		return today;
	}

	 
	

	// init
	@PostConstruct
	public void init() {
		orderlines = orderlineservice.allOrderLineByStore(2);
		orderlinesRecents = orderlineservice.triOrderLineBydate(2);
		produits = orderlineservice.getAllProductByStore(2);
		produitsFromOrders = orderlineservice.getAllProductfromOrder(2);
		for (Object[] result : produitsFromOrders) {
		    Product p = (Product) result[0];
		    System.out.println("pppp "+p.getLibelle());
		    int count = ((Number) result[1]).intValue();
		    System.out.println("qttttt "+count);
		}
	
	
	
	
	}
	
	
	
	
	 public void onRowSelect(SelectEvent event) {
		 OrderLine ol = (OrderLine) event.getObject();
		 System.out.println("event oderline:  **** "+ol.getIdOrderLine());
		 Boolean x; 
			x=orderlineservice.verifyDisponibility(ol.getIdOrderLine());
			System.out.println("boolean **** "+x);
			if(x==true)
			{
				
				
				FacesMessage msg = new FacesMessage("Available Product");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		        
			}
			else 
			{
				
				FacesMessage msg = new FacesMessage("Critical zone Stock");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		     
			}
	       
	       
	    }
	 public void onRowSelect2(SelectEvent event) {
		 	Product p= (Product) event.getObject();
		System.out.println("prod selectedddd ***** ==== "+ p.getLibelle());
		 /*	try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("addmvtstock.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */
		if(p.getQte() < p.getCriticalZone())
		{
		 	try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:18080/JSFtunisiamall-web/orderlinePages/ficheproductqte.jsf?productId=" + p.getIdProduct());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else 
		{
			FacesMessage msg = new FacesMessage("Your PRODUCT is SAFE");
			
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	 }
	 
	 
	 public Product getProductFromRequest()
	 {
		 FacesContext context = FacesContext.getCurrentInstance();
		    Map requestParams = context.getExternalContext().getRequestParameterMap();
		    String id = (String) requestParams.get("productId");
		    productParam = mvtstockservice.findProductByIdString(Integer.parseInt(id));
		    System.out.println("paraaaam ***** : "+productParam.getIdProduct());
		   return productParam;
		}
	 
	 
	 
	  public void goToAddProduct()
	  {
		  try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:18080/JSFtunisiamall-web/orderlinePages/addmvtstock.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  public void returnToDashboard()
	  {
		  try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:18080/JSFtunisiamall-web/orderlinePages/orderlinelist.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
