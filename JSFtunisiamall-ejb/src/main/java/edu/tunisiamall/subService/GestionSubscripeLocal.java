package edu.tunisiamall.subService;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Subscription;

@Local
public interface GestionSubscripeLocal {
	public List<Subscription> findAllSub();

}
