package cat.dbuenov.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.dbuenov.app.model.User;

public interface UsersRepository extends MongoRepository<User, String>{

	int countByUserName(String userName);	
}
