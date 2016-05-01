package edu.tunisiamall.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesLocal;

@ManagedBean
@SessionScoped
public class StoreBean {
	private static int idShopOwner = 1;
	private List<Store> storesList;
	private int count;
	private Store store;
	private int idStore;
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
		for (Store store : storesList) {
			if (store.getIdStore() == idstore) {
				store.setStatus("Open");
				break;
			}
		}
	}

	public void close(int idstore) {
		storeEJB.closeStore(idstore);
		for (Store store : storesList) {
			if (store.getIdStore() == idstore) {
				store.setStatus("Closed");
				break;
			}
		}
	}

	public void getCurrentStore() {
		this.store = storeEJB.findStoreById(this.idStore);
	}

	public void getCurrentStoresList() {
		this.storesList = storeEJB.findStoreByShopOwner(idShopOwner);
		count = storesList.size();
	}

	public void editStore() {
		storeEJB.updateStoreDetails(store);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("list.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initLayout() {
		this.store = storeEJB.findStoreById(this.idStore);
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
		this.layoutList = list;
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

	public int getIdStore() {
		return idStore;
	}

	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}

	public List<String[]> getLayoutList() {
		return layoutList;
	}

	public void setLayoutList(List<String[]> layoutList) {
		this.layoutList = layoutList;
	}

}
