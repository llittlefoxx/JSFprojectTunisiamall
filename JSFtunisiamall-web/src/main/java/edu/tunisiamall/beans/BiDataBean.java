package edu.tunisiamall.beans;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import edu.tunisiamall.biservices.IndicatorsServiceLocal;
import edu.tunisiamall.entities.Product;

@ManagedBean(name="bi")
@RequestScoped
public class BiDataBean {

	@EJB
	IndicatorsServiceLocal indicators;
	
	public double totalIncome(){
		return indicators.getTotalIncome();
	}
	public  HashMap<Product, Integer> getHotProducts(){
		return indicators.getHotProducts();
	}

	public Map<String, Double> getMonthlyIncome(){
		return indicators.getMonthlyIncome();
	}
}
