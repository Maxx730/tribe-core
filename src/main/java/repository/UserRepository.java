package repository;
import models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findById(String id);
    void deleteUserByUsername(String username);
    List<User> findUserByUsername(String username);
    List<User> findUserByEmail(String email);
}
