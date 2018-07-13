package tools;

import models.Event;
import models.Tribe;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import repository.EventRepository;
import repository.TribeRepository;
import repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Component
@Order(value = 2)
public class Seeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TribeRepository tribeRepo;
    @Autowired
    private EventRepository eventRepo;

    @Override
    public void run(String... args) throws Exception {

        userRepo.deleteAll();
        tribeRepo.deleteAll();
        eventRepo.deleteAll();

        //Next we are going to add some mock users.
        User user1 = new User();
        user1.setEmail("max.kinghorn@gmail.com");
        user1.setFirstname("Max");
        user1.setLastname("Kinghorn");
        user1.setUsername("Maxx730");
        user1.setPassword("remote12");

        Tribe tribe1 = new Tribe();
        tribe1.setTitle("Burlingtonites");
        tribe1.setDescription("Everyone that lives in Burlington Vermont.");
        tribe1.setCreator(user1);

        userRepo.insert(user1);
        tribeRepo.insert(tribe1);
    }
}
