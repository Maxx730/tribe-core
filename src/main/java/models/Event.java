package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "events")
public class Event {
    @Autowired
    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String description;

    @Field
    private User creator;

    @Field
    private Date start;

    @Field
    private Date end;

    public Event(){

    }

    //Getters
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){return this.description;}
    public User getCreator(){return this.creator;}
    public Date getStart(){return this.start;}
    public Date getEnd(){return this.end;}
}
