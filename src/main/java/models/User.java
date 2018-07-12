package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {
    @Autowired
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        //Set the names as default to no name.
        this.firstname = "No Name";
        this.lastname = "No Name";
    }

    //Getters start here.
    public String getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    //Setters start here.
    public void setEmail(String email){
        this.email = email;
    }
    public void setUsername(){}
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }

}
