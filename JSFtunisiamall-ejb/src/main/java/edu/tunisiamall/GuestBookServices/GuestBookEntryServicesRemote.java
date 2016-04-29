package edu.tunisiamall.GuestBookServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Gestbookentry;
import edu.tunisiamall.entities.User;;

@Remote
public interface GuestBookEntryServicesRemote {
	public void deleteEntries(int id);

	public Gestbookentry findEntryById(int idEtries);

	public List<Gestbookentry> findAll();

	public boolean addGuestbookEntry(int idUser, String text);
}
