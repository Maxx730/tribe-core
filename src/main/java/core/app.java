package core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers","tools"})
@EnableMongoRepositories(basePackageClasses = {repository.UserRepository.class})
public class app {

    public static void main(String args[]){
        SpringApplication.run(app.class,args);
    }
}
