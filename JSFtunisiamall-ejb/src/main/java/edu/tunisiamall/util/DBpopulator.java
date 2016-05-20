package edu.tunisiamall.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.categorieServices.CategoryServicesRemote;
import edu.tunisiamall.entities.Administrator;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.entities.Subcategory;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;
import edu.tunisiamall.userServices.userServicesRemote;

public class DBpopulator {

	@EJB
	IndicatorsServiceRemote indicatorsServiceRemote;
	@EJB
	CategoryServicesRemote categoryServicesRemote;
	@EJB
	userServicesRemote userServicesRemote;

	public DBpopulator() {

	}

	@PostConstruct
	public void createData() {
		Date date=new Date();
		/*
		Administrator admin = userServicesRemote.f
		Customer c1 =  userServicesRemote.find(2);
		Customer c2 =  userServicesRemote.find(3);
		Shopowner s1 =  userServicesRemote.find(4);
		Shopowner s2 =  userServicesRemote.find(5);
		
		
		Category category=new Category("Cette categorie contient des vettement hiver","Winter Clothes");
		Category category1=new Category("Cette categorie contient des produis alimentaire","Food");
		Category category2=new Category("Cette categorie contient du matériel informatique","Computers");
		
		Store store = new Store("Store for fashion",category,"BERSHKA",date,"OPEN","33333333",s1);
		Store store1 = new Store("Food store",category,"CARREFOUR",date,"OPEN","33333332",s1);
		Store store2 = new Store("Technology store",category,"MEDIA-TEK",date,"OPEN","33333331",s2);
		
		Subcategory subCategory=new Subcategory("this sub-category contains Shoes","Shoes",category);
		Subcategory subCategory1=new Subcategory("this sub-category contains food","Cake",category1);
		Subcategory subCategory2=new Subcategory("this sub-category contains Laptops","Laptops",category2);
		
		Promotion promotion=new Promotion("Promo ETE",20.0,true,date,date);
		Promotion promotion1=new Promotion("Promo HIVER",15.0,true,date,date);
		
		Product product=new Product(15.0,date,"Nike shoes",250,15,79.900,"Available","shoes",18,promotion,null,store,subCategory);
		Product product1=new Product(19.0,date,"Laptop Acer",250,15,982.600,"Available","Computer",18,promotion1,null,store2,subCategory);
		Product product2=new Product(25.0,date,"Biscuit Major",250,15,800,"Available","Food",18,null,null,store1,subCategory);
		Product product3=new Product(25.0,date,"Biscuit Major",250,15,800,"Available","Food",18,null,null,store,subCategory);
		
		userServicesRemote.create(admin);
		userServicesRemote.create(c1);
		userServicesRemote.create(c2);
		userServicesRemote.create(s1);
		userServicesRemote.create(s2);
		
		categoryServicesRemote.addCategory(category);
		categoryServicesRemote.addCategory(category1);
		categoryServicesRemote.addCategory(category2);
		
		categoryServicesRemote.addSubCategory(subCategory);
		categoryServicesRemote.addSubCategory(subCategory1);
		categoryServicesRemote.addSubCategory(subCategory2);
		
		indicatorsServiceRemote.createPromotion(promotion);
		indicatorsServiceRemote.createPromotion(promotion1);
		
		categoryServicesRemote.addProduct(product);
		categoryServicesRemote.addProduct(product1);
		categoryServicesRemote.addProduct(product2);
		categoryServicesRemote.addProduct(product3);
		*/
		
	}

}
