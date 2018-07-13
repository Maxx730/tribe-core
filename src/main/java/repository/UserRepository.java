package repository;
import models.Tribe;
import models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    @Query("{_id:?0}")
    User findMemberByStringId(String id);
    void deleteUserByUsername(String username);
    List<User> findUserByUsername(String username);
    List<User> findUserByEmail(String email);

    //Returns a list of users based on the given list of ids.
    @Query("{}")
    public List<User> findUserList(List<String> ids);
}
