package edu.tunisiamall.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import edu.tunisiamall.biservices.IndicatorsServiceLocal;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.util.Stat;

@ManagedBean(name="expo")
public class DataExporterView {

	private List<Product> hotProducts=new ArrayList<Product>();
	
	 private LineChartModel animatedModel1;
	 private BarChartModel animatedModel2;
	 private List<Stat> monthly;
	 


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
		 createAnimatedModels();
		hotOrigin=indicators.getHotProducts();
		System.out.println(" hot origin "+hotOrigin.size());
		for(Map.Entry<Product, Integer> e : hotOrigin.entrySet()){
			e.getKey().setQte(e.getValue());
			hotProducts.add(e.getKey());
		}
	}

	  private void createAnimatedModels() {
	        animatedModel1 = initLinearModel();
	        animatedModel1.setTitle("Line Chart");
	        animatedModel1.setAnimate(true);
	        animatedModel1.setLegendPosition("se");
	        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	         
	        animatedModel2 = initBarModel();
	        animatedModel2.setTitle("Monthly income");
	        animatedModel2.setAnimate(true);
	        animatedModel2.setLegendPosition("ne");
	        yAxis = animatedModel2.getAxis(AxisType.Y);
	        yAxis.setMin(0);
	        yAxis.setMax(9999);
	    }
	     
	    private BarChartModel initBarModel() {
	        BarChartModel model = new BarChartModel();
	 
	        ChartSeries boys = new ChartSeries();
	        monthly=indicators.getMonthlyIncome();
	        boys.setLabel("Monthly income");
	   for (Stat mon : monthly) {
		   boys.set(mon.getMonth(), mon.getVal());
	}
	    	
		
	       
	 
	      /*  ChartSeries girls = new ChartSeries();
	        girls.setLabel("Girls");
	        girls.set("2004", 52);
	        girls.set("2005", 60);
	        girls.set("2006", 110);
	        girls.set("2007", 135);
	        girls.set("2008", 120);*/
	 
	        model.addSeries(boys);
	       // model.addSeries(girls);
	         
	        return model;
	    }
	     
	    private LineChartModel initLinearModel() {
	        LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Series 1");
	 
	        series1.set(1, 2);
	        series1.set(2, 1);
	        series1.set(3, 3);
	        series1.set(4, 6);
	        series1.set(5, 8);
	 
	        LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Series 2");
	 
	        series2.set(1, 6);
	        series2.set(2, 3);
	        series2.set(3, 2);
	        series2.set(4, 7);
	        series2.set(5, 9);
	 
	        model.addSeries(series1);
	        model.addSeries(series2);
	         
	        return model;
	    }
	public List<Product> getHotProducts() {
		return hotProducts;
	}

	public void setHotProducts(List<Product> hotProducts) {
		this.hotProducts = hotProducts;
	}


	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}


	public void setAnimatedModel1(LineChartModel animatedModel1) {
		this.animatedModel1 = animatedModel1;
	}


	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}


	public void setAnimatedModel2(BarChartModel animatedModel2) {
		this.animatedModel2 = animatedModel2;
	}
	
	
	
}
