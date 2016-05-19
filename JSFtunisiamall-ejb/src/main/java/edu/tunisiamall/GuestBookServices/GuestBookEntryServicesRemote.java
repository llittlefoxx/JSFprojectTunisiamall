package edu.tunisiamall.GuestBookServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Guestbookentry;
import edu.tunisiamall.entities.User;;

@Remote
public interface GuestBookEntryServicesRemote {
	public void deleteEntries(int id);

	public Guestbookentry findEntryById(int idEtries);

	public List<Guestbookentry> findAll();

	public boolean addGuestbookEntry(int idUser, String text);
}
