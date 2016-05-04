package edu.tunisiamall.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import edu.tunisiamall.biservices.IndicatorsServiceLocal;
import edu.tunisiamall.entities.Product;

@ManagedBean(name="expo")
public class DataExporterView {

	private List<Product> hotProducts=new ArrayList<Product>();
	

	public Map<Product, Integer> getHotOrigin() {
		return hotOrigin;
	}


	public void setHotOrigin(Map<Product, Integer> hotOrigin) {
		this.hotOrigin = hotOrigin;
	}

	@EJB
	IndicatorsServiceLocal indicators;
	
	public Map<Product, Integer> hotOrigin;
	
	@PostConstruct
	public void init(){
		hotOrigin=indicators.getHotProducts();
		System.out.println(" hot origin "+hotOrigin.size());
		for(Map.Entry<Product, Integer> e : hotOrigin.entrySet()){
			e.getKey().setQte(e.getValue());
			hotProducts.add(e.getKey());
		}
	}

	
	public List<Product> getHotProducts() {
		return hotProducts;
	}

	public void setHotProducts(List<Product> hotProducts) {
		this.hotProducts = hotProducts;
	}
	
	
	
}
