package cat.dbuenov.app.service;

import cat.dbuenov.app.model.User;

public interface IServiceRepository {

	public User addUser(User user);
	public User deleteUser(String id);
	public User getUser(String id);	
	public User changeUser(String id, User user);	
}
