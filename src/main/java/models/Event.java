package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

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

    //Getters
    public String getTitle(){
        return this.title;
    }
}
