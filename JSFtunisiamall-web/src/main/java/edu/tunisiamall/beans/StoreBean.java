package edu.tunisiamall.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesLocal;

@ManagedBean
@SessionScoped
public class StoreBean {
	private static int idShopOwner = 1;
	private List<Store> storesList;
	private int count;
	private Store store;
	private List<String[]> layoutList;
	@EJB
	StoreServicesLocal storeEJB;

	// methods
	@PostConstruct
	public void init() {
		this.storesList = storeEJB.findStoreByShopOwner(idShopOwner);
		this.count = storesList.size();
		this.store = new Store();
		this.layoutList = new ArrayList<String[]>();
	}

	public void reopen(int idstore) {
		storeEJB.reopenStore(idstore);
		storesList = storeEJB.findStoreByShopOwner(idShopOwner);
	}

	public void close(int idstore) {
		storeEJB.closeStore(idstore);
		storesList = storeEJB.findStoreByShopOwner(idShopOwner);
	}

	public String editStore(int idStore) {
		String redirectTo = "edit?faces-redirect=true";
		store = storeEJB.findStoreById(idStore);
		return redirectTo;
	}
	
	public String updateStore(){
		String redirectTo = "list?faces-redirect=true";
		storeEJB.updateStoreDetails(store);
		storesList = storeEJB.findStoreByShopOwner(idShopOwner);
		return redirectTo;
	}

	public List<String[]> initLayout(int idStore) {
		this.store = storeEJB.findStoreById(idStore);
		List<String[]> list = new ArrayList<String[]>();
		for (int i = 0; i < 9; i++) {
			String[] array = new String[3];
			array[0] = store.getLayout().charAt(i) + "";
			if (store.getLayout().charAt(i) == '0') {
				array[1] = "Newest Products";
			} else if (store.getLayout().charAt(i) == '1') {
				array[1] = "Hottest Products";
			} else if (store.getLayout().charAt(i) == '2') {
				array[1] = "Sub-Categories";
			} else if (store.getLayout().charAt(i) == '3') {
				array[1] = "Promotions & Events";
			} else if (store.getLayout().charAt(i) == '4') {
				array[1] = "Store Details";
			} else if (store.getLayout().charAt(i) == '5') {
				array[1] = "Contact Us";
			} else if (store.getLayout().charAt(i) == '6') {
				array[1] = "Image";
			} else if (store.getLayout().charAt(i) == '7') {
				array[1] = "Video";
			} else if (store.getLayout().charAt(i) == '8') {
				array[1] = "Virtual Visit";
			}
			array[2] = store.getLayout().charAt(i + 9) + "";
			list.add(array);
		}
		return layoutList = list;
	}

	public void editLayout() {
		String layout = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("layout");
		store.setLayout(layout);
		storeEJB.updateStoreDetails(store);
	}

	public List<Store> getStoresList() {
		return storesList;
	}

	public void setStoresList(List<Store> storesList) {
		this.storesList = storesList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<String[]> getLayoutList() {
		return layoutList;
	}

	public void setLayoutList(List<String[]> layoutList) {
		this.layoutList = layoutList;
	}

}
