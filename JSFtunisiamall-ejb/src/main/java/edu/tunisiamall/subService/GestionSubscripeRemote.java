package edu.tunisiamall.subService;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Subscription;

@Remote
public interface GestionSubscripeRemote {
	public List<Subscription> findAllSub();

}
