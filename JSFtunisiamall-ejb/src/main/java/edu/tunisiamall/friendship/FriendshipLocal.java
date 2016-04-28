package edu.tunisiamall.friendship;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Friendship;

@Local
public interface FriendshipLocal {
	public boolean sendFriendRequest(int idSrc, int idDest);

	public boolean acceptFriendRequest(int idRequest);

	public List<Friendship> getRequestFor(int idUser);

	public List<Friendship> getFriendsList(int idUser);

	public boolean deleteFriend(int id);
	
	public boolean exist(int idSrc, int idDest);
}
