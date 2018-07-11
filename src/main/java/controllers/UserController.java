package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import tools.Response;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepo;

    //Returns all the users in the database (Testing/Learning purposes)
    @GetMapping(path = "/all")
    public List<User> GetAll(){
        List<User> users = this.userRepo.findAll();
        return users;
    }

    //Returns the Tribe user with the given id.
    @GetMapping(value= "/{id}")
    public Optional<User> GetUser(@PathVariable("id") String id){
        Optional<User> user = this.userRepo.findById(id);
        return user;
    }

    @GetMapping(value = "/email/{email}")
    public List<User> FindByEmail(@PathVariable("email") String email){
        List<User> users = this.userRepo.findUserByEmail(email);
        return users;
    }

    //Creates a new Tribe user.
    @PutMapping(path = "/create")
    public String CreateUser(@RequestBody User user){
        ObjectMapper m = new ObjectMapper();
        Response r = new Response("SUCCESS","USER CREATED");
        //First we want to check if the username and email are not going to be repeats.
        if(this.CheckEmailExists(user.getEmail()) && this.CheckUsernameExists(user.getUsername())){
            //Then we can create and add the user to the database.
            userRepo.insert(user);
        }else{
            r.setType("ERROR");
            r.setMessage("USERNAME OR EMAIL ALREADY EXISTS");
        }

        try {
            return m.writeValueAsString(r);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR PARSING JSON";
        }
    }

    //Check and log in the user when accessing this end point.
    @PostMapping(path = "/login")
    public String LoginUser(@RequestBody User user){
        List<User> users = this.userRepo.findUserByUsername(user.getUsername());
        ObjectMapper m = new ObjectMapper();
        Response r = new Response("SUCCESS","LOGIN SUCCEEDED");

        if(users.size() == 1 && users.get(0).getPassword() == user.getPassword()){
            //User has successfully logged into the system.

        }else{
            //User has failed to log into the system.
            r.setType("ERROR");
            r.setMessage("USERNAME OR PASSWORD INCORRECT");
        }

        try{
            return m.writeValueAsString(r);
        }catch(JsonProcessingException e){
            return "ERROR PARSING JSON";
        }
    }

    //Updates information about a Tribe User
    @PostMapping(path = "/update")
    public String UpdateUser(User user){
        return "UPDATED!!!";
    }

    //Deletes a user from the database based on the ID in the url.
    @DeleteMapping(value = "/delete/{name}")
    public void DeleteUser(@PathVariable("name") String name){
        this.userRepo.deleteUserByUsername(name);
    }

    //Functions used for checking to make sure we do not get duplicate usernames
    //and or duplicate emails.
    private Boolean CheckEmailExists(String email){
        List<User> users = this.userRepo.findUserByEmail(email);

        if(users.size() > 0){
            return false;
        }else{
            return true;
        }
    }

    private Boolean CheckUsernameExists(String username){
        List<User> users = this.userRepo.findUserByUsername(username);

        if(users.size() > 0){
            return false;
        }else{
            return true;
        }
    }
}
