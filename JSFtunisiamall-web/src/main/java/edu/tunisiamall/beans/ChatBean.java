package edu.tunisiamall.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.tunisiamall.communication.MessageServiceLocal;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;

@ManagedBean
@SessionScoped
public class ChatBean {
	private List<Message> inbox;
	private static int currentIdUser = 1;
	private List<Message> conversation;
	private Message message;
	
	public List<Message> Inbox(){
		return inbox = messageService.getMessagesFor(currentIdUser);
	}
	
	public String Converstation(int idUser){
		String navigateTo = "/Chat/conversation?faces-redirect=true";
		conversation = messageService.getMessagesFromTo(currentIdUser, idUser);
		return navigateTo;
	}
	
	public void SendMessage(int idUser){
		messageService.sendMessage(currentIdUser, idUser, message.getText());
		conversation = messageService.getMessagesFromTo(currentIdUser, idUser);
	}
	
	public void DeleteMessage(int idUser, int idMessage){
		messageService.deleteMessage(idMessage);
		conversation = messageService.getMessagesFromTo(currentIdUser, idUser);
	}
	
	public List<User> UsersList(){
		return userService.findAll();
	}
	
	public List<Message> getInbox() {
		return inbox;
	}
	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}
	public int getCurrentIdUser() {
		return currentIdUser;
	}
	public void setCurrentIdUser(int currentIdUser) {
		this.currentIdUser = currentIdUser;
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
	
	@EJB
	MessageServiceLocal messageService;
	@EJB
	userServicesLocal userService;
	
	@PostConstruct
	public void init(){
		message = new Message();
		message.setReceiver(new User());
	}
}
