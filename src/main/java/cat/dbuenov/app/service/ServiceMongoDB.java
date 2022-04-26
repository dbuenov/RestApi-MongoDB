package cat.dbuenov.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.dbuenov.app.exceptions.UserNotFoundException;
import cat.dbuenov.app.exceptions.UserExistException;
import cat.dbuenov.app.model.*;
import cat.dbuenov.app.repository.*;

@Service
public class ServiceMongoDB implements IServiceRepository{

	@Autowired
	UsersRepository users;
		
	@Override
	public User addUser(User user) {
		
		//vigilo que no se repitan                               
		int countUsers = users.countByUserName(user.getUserName());
		if (countUsers>0)  {
			throw new UserExistException(user.getUserName());			
		}
		return users.save(user);
	}
	
	@Override
	public User deleteUser(String id) {
		Optional<User> user = users.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException(id);
		}
		users.deleteById(id);
		return null;
	}
			
	@Override
	public User getUser(String id) {
		Optional<User> user = users.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException(id);
		}
		return user.get();
	}
	
	@Override
	public User changeUser(String id, User user) {
		
		//vigilo los repetidos
		if (users.countByUserName(user.getUserName())>0)  {
			throw new UserExistException(user.getUserName());			
		}
		User original = getUser(id);
		original.setUserName(user.getUserName());	
		return users.save(original);
	}		
}
