package edu.tunisiamall.communication;

import java.util.List;
import javax.ejb.Remote;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.entities.Message;

@Remote
public interface MessageServiceRemote {
	public List<Message> getMessagesFromTo(User src, User dest);
	public List<Message> getMessagesFor(User u);
	public Message sendMessage(User src, User dest, String text);
	public boolean deleteMessage(int id);
}
