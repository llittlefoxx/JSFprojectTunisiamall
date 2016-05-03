package edu.tunisiamall.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import edu.tunisiamall.communication.MessageServiceLocal;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;

@ManagedBean
@SessionScoped
public class ChatBean {
	private List<Message> inbox;
	private static int currentUserId = 1;
	private int otherUserId;
	private List<Message> conversation;
	private Message message;

	public List<Message> Inbox() {
		return inbox = messageService.getMessagesFor(currentUserId);
	}

	public String Converstation(int idUser) {
		String navigateTo = "/Chat/conversation?faces-redirect=true";
		conversation = messageService.getMessagesFromTo(currentUserId, idUser);
		otherUserId = idUser;
		return navigateTo;
	}

	public void SendMessage() {
		messageService.sendMessage(currentUserId, otherUserId, message.getText());
		conversation = messageService.getMessagesFromTo(currentUserId, otherUserId);
		message = new Message();
		message.setReceiver(new User());
	}

	public void DeleteMessages() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String txtAnotherProperty = request.getParameter("toDelete");
		if (txtAnotherProperty.length() > 0) {
			String[] array = txtAnotherProperty.split(";");
			for (String idMessage : array) {
				int id = Integer.parseInt(idMessage);
				messageService.deleteConversation(id);
			}
		}
		inbox = messageService.getMessagesFor(currentUserId);
	}

	public List<User> UsersList() {
		return userService.findAll();
	}

	public List<Message> getInbox() {
		return inbox;
	}

	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}

	public int getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(int currentIdUser) {
		currentUserId = currentIdUser;
	}

	public List<Message> getConversation() {
		return conversation;
	}

	public void setConversation(List<Message> conversation) {
		this.conversation = conversation;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getOtherUserId() {
		return otherUserId;
	}

	public void setOtherUserId(int otherUserId) {
		this.otherUserId = otherUserId;
	}

	@EJB
	MessageServiceLocal messageService;
	@EJB
	userServicesLocal userService;

	@PostConstruct
	public void init() {
		message = new Message();
		message.setReceiver(new User());
	}
}
