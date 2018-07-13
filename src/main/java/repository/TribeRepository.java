package repository;

import models.Tribe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TribeRepository extends MongoRepository<Tribe,String> {

    @Query("{_id:?0}")
    public Tribe findTribeBy_Id(String id);
}
