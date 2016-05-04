package customerBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;

@ManagedBean
@SessionScoped
public class AuthenticationBean {

	@EJB
	userServicesLocal service;
	private User user;
	private boolean loggedIn = false;
	private String userType;

	public AuthenticationBean() {
	}

	@PostConstruct
	public void init() {
		user = new User();
	}

	public String connect() {

		String navigateTo = "";

		user = service.authentificate(user.getLogin(), user.getPassword());

		if (null == user) {
			loggedIn = false;
			user = new User();

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "WRONG CREDENTIALS!",
					"LOGIN OR PASSWORD ARE NOT VALID!");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} else {
			loggedIn = true;

			HttpSession session = SessionBean.getSession();
			session.setAttribute("username", user);

			if (user instanceof Shopowner) {

				navigateTo = "/home/index?faces-redirect=true";
				userType = "admin";

			} else if (user instanceof Customer) {

				navigateTo = "/pages/customer/home";
				userType = "customer";
			}
		}
		return navigateTo;
	}

	public String logout() {
		loggedIn = false;
		user = new User();
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "/customer/Authentification?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String desactiverUser() {
		service.delete(user.getIdUser());
		return "/customer/Authentification?faces-redirect=true";
	}

}
