package edu.tunisiamall.GuestBookServices;

import java.util.List;
import javax.ejb.Local;
import edu.tunisiamall.entities.Gestbookentry;
import edu.tunisiamall.entities.User;

@Local
public interface GuestBookEntryServicesLocal {
	public void deleteEntries(int id);

	public Gestbookentry findEntryById(int idEtries);

	public List<Gestbookentry> findAll();

	public boolean addGuestbookEntry(int idUser, String text);
}
