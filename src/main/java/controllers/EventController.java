package controllers;

import models.Event;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @RequestMapping(value = "/{id}")
    public String GetEvent(@PathVariable String id){
        return "FINDING EVENT: " + id;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String CreateEvent(Event event){
        return "CREATING EVENT: " + event.getTitle();
    }
}
