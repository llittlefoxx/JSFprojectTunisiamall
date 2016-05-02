package edu.tunisiamall.communication;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;

@Local
public interface MessageServiceLocal {
	public List<Message> getMessagesFromTo(int idSrc, int idDest);
	public List<Message> getMessagesFor(int idUser);
	public void sendMessage(int idSrc, int idDest, String text);
	public void deleteMessage(int id);
}
