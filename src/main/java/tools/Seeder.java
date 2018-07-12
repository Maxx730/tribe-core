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
        //Occupy our databse with mock users.
        userRepo.deleteAll();
        User admin = new User("TribeGOD","dRmario43");

        User member1 = new User("Molx730","remote12");
        User member2 = new User("Tombomb","remote12");
        User member3 = new User("CradamLeb","remote12");
        User member4 = new User("MandleMandy","remote12");
        List<User> users = Arrays.asList(
                admin,
                member1,
                member2,
                member3,
                member4
        );
        userRepo.insert(users);

        //Populate the database with event objects.
        eventRepo.deleteAll();

        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();

        List<Event> events = Arrays.asList(
                event1,
                event2,
                event3
        );

        eventRepo.insert(events);

        //Ocuppy our database with mock Tribes.
        tribeRepo.deleteAll();
        Tribe tribe1 = new Tribe();

        tribe1.setTitle("First Tribe");
        tribe1.setDescription("This is the first Tribe in the database.");
        tribe1.setCreator(admin);
        tribe1.addMember(member1);
        tribe1.addMember(member2);

        Tribe tribe2 = new Tribe();

        tribe2.setTitle("Second Tribe");
        tribe2.setDescription("This is the second Tribe in the database.");
        tribe2.setCreator(admin);
        tribe2.addMember(member1);
        tribe2.addMember(member4);

        Tribe tribe3 = new Tribe();

        tribe3.setTitle("Third Tribe");
        tribe3.setDescription("This is the third Tribe in the database.");
        tribe3.setCreator(admin);
        tribe3.addMember(member1);
        tribe3.addMember(admin);
        tribe3.addMember(member3);
        tribe3.addMember(member4);

        List<Tribe> tribes = Arrays.asList(
                tribe1,tribe2,tribe3
        );

        tribeRepo.insert(tribes);

    }
}
