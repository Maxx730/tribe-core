package repository;

import models.Tribe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TribeRepository extends MongoRepository<Tribe,String> {

}
