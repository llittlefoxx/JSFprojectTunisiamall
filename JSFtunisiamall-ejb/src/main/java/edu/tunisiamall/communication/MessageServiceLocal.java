package edu.tunisiamall.communication;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;

@Local
public interface MessageServiceLocal {
	public List<Message> getMessagesFromTo(User src, User dest);
	public List<Message> getMessagesFor(User u);
	public Message sendMessage(User src, User dest, String text);
	public boolean deleteMessage(int id);
}
