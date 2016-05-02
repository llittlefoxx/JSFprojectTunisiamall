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
	public void sendMessage(int idSrc, int idDest, String text) {
		User src = em.find(User.class, idSrc);
		User dest = em.find(User.class, idDest);
		Message m = new Message(src, dest, text);
		em.persist(m);
	}

	@Override
	public void deleteMessage(int id) {
		em.remove(em.find(Message.class, id));
	}

	@Override
	public List<Message> getMessagesFromTo(int idSrc, int idDest) {
		Query query = em
				.createQuery(
						"select m from Message m where (m.receiver.idUser = :src and m.sender.idUser = :dest) or (m.receiver.idUser = :dest and m.sender.idUser = :src) order by m.date desc")
				.setParameter("src", idSrc).setParameter("dest", idDest);
		return query.getResultList();
	}

	@Override
	public List<Message> getMessagesFor(int idUser) {
		List<Message> listOfMessages = new ArrayList<>();
		User u = em.find(User.class, idUser);
		Query query = em.createQuery("select distinct m.sender from Message m where m.receiver = :user")
				.setParameter("user", u);
		Query query2 = em
				.createQuery(
						"select m from Message m where m.sender = :user and m.receiver = :receiver order by m.date desc")
				.setParameter("receiver", u).setMaxResults(1);
		try {
			List<User> results = query.getResultList();
			for (User user : results) {
				query2.setParameter("user", user);
				List<Message> messages = (List<Message>) query2.getResultList();
				if (messages.size() > 0) {
					listOfMessages.add(messages.get(0));
				}
			}
			return listOfMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return listOfMessages;
		}
	}

}
