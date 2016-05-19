package edu.tunisiamall.GuestBookServices;

import java.util.List;
import javax.ejb.Local;
import edu.tunisiamall.entities.Guestbookentry;
import edu.tunisiamall.entities.User;

@Local
public interface GuestBookEntryServicesLocal {
	public void deleteEntries(int id);

	public Guestbookentry findEntryById(int idEtries);

	public List<Guestbookentry> findAll();

	public boolean addGuestbookEntry(int idUser, String text);
}
