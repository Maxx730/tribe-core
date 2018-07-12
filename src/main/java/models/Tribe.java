package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "tribes")
public class Tribe {
    @Autowired
    @Id
    private String id;
    private String title;
    private String description;
    private Date created;
    private User creator;
    private ArrayList<User> members;
    private ArrayList<Event> events;

    public Tribe(){
        this.created = new Date();

        this.members = new ArrayList<User>();
        this.events = new ArrayList<Event>();
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public Date getCreated(){
        return this.created;
    }

    public User getCreator(){
        return this.creator;
    }

    public ArrayList<User> getMembers(){
        return this.members;
    }

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    //Setters begin here.
    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public void setCreator(User user){
        this.creator = user;
    }

    public void addMember(User member){
        this.members.add(member);
    }
}
