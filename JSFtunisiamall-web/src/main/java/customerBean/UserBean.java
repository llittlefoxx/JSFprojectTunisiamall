package customerBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.shopOwnerServices.shopOwnerServiceLocal;

@ManagedBean
@ViewScoped
public class UserBean {

	@EJB
	shopOwnerServiceLocal Uservice;
	Shopowner customer;
	AuthenticationBean bean = new AuthenticationBean();

	public UserBean() {

	}

	@PostConstruct
	public void init() {

		customer = new Shopowner();

	}

	public String addUser() {
		String redirectTo = "/home/index?faces-redirection=true";
		Uservice.create(customer);
		System.out.println(customer.getLogin());
		return redirectTo;
	}

	public void updateUser(Shopowner cus) {

		Uservice.updateShopeOwner(cus);

	}

	public Shopowner getCustomer() {
		return customer;
	}

	public void setCustomer(Shopowner customer) {
		this.customer = customer;
	}

}
