package customerBean;



import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import edu.tunisiamall.customerServices.customerServicesLocal;
import edu.tunisiamall.entities.Customer;


@ManagedBean
@ViewScoped
public class UserBean {

	@EJB
	customerServicesLocal Uservice;
	Customer customer ;	
	
	public UserBean() {
		
	}
@PostConstruct
	public void init() {
		
		
		customer=new Customer();
		customer.setLogin("test");
		customer.setPassword("test");
	
	}
	
	public void addUser(){
		
		Uservice.create(customer);
		System.out.println(customer.getLogin());
		
	}
	public void updateUser(Customer cus){
		
		Uservice.updateCustomer(cus);
		
	}
	public customerServicesLocal getUservice() {
		return Uservice;
	}
	public void setUservice(customerServicesLocal uservice) {
		Uservice = uservice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

	
}
