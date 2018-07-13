package repository;
import models.User;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    //Finds a user from the system based on the given ID
    @Query("{_id:?0}")
    User findMemberByStringId(String id);
    //Deletes a user from the system based on the given ID
    @DeleteQuery("{_id:?0}")
    void deleteByUserId(String id);
    //Finds Users based on name and or email.
    List<User> findUserByUsername(String username);
    List<User> findUserByEmail(String email);
    //Returns a list of users based on the given list of ids.
    @Query("{_id:?0}")
    public List<User> findUserList(List<String> ids);
}
