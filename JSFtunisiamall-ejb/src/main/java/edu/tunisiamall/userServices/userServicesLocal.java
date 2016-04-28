package edu.tunisiamall.userServices;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.User;

@Local
public interface userServicesLocal {
	
	void create(User user);
	public User authentificate(String login, String password);
	public void delete(int id);
	public List<User> findAll();
	public User find(int id);
	public User findByLogin(String login);
	public Shopowner findShopOwnerById (int idShopowner);
	

}
