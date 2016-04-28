package edu.tunisiamall.communication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;

@Stateless
public class MessageService implements MessageServiceRemote, MessageServiceLocal {

	@PersistenceContext
	EntityManager em;

	public MessageService() {
	}

	@Override
	public Message sendMessage(User src, User dest, String text) {
		try {
			if (text.trim().length() == 0 || src == null || dest == null) {
				throw new Exception("Empty message or one of the users is null");
			}
			Message m = new Message(src, dest, text);
			em.persist(m);
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteMessage(int id) {
		try {
			em.remove(em.find(Message.class, id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Message> getMessagesFromTo(User src, User dest) {
		Query query = em.createQuery("select m from Message m where (m.receiver = :src and m.sender = :dest) or (m.receiver = :dest and m.sender = :src) order by m.date desc")
				.setParameter("src", src)
				.setParameter("dest",dest);
		List<Message> results = (List<Message>) query.getResultList();
		return results;
	}

	@Override
	public List<Message> getMessagesFor(User u) {
		List<Message> listOfMessages = new ArrayList<>();
		Query query = em.createQuery("select distinct m.sender from Message m where m.receiver = :user")
				.setParameter("user", u);
		Query query2 = em.createQuery("select m from Message m where m.sender = :user and m.receiver = :receiver order by m.date desc")
						.setParameter("receiver", u)
						.setMaxResults(1);
		try{
			List<User> results = query.getResultList();
			for (User user : results) {
				query2.setParameter("user", user);
				List<Message> messages = (List<Message>) query2.getResultList();
				if(messages.size() > 0){
					listOfMessages.add(messages.get(0));
				}
			}
			return listOfMessages;
		}
		catch(Exception e){
			e.printStackTrace();
			return listOfMessages;
		}
	}

}
