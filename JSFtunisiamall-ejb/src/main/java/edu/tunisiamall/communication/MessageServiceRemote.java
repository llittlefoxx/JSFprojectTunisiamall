package edu.tunisiamall.communication;

import java.util.List;
import javax.ejb.Remote;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.entities.Message;

@Remote
public interface MessageServiceRemote {
	public List<Message> getMessagesFromTo(int src, int dest);
	public List<Message> getMessagesFor(int idUser);
	public void sendMessage(int src, int dest, String text);
	public void deleteMessage(int id);
}
