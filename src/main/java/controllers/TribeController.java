package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Tribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.TribeRepository;
import tools.Response;

import java.util.List;

@RestController
@RequestMapping("/tribes")
public class TribeController {

    @Autowired
    TribeRepository tribeRepo;

    @GetMapping(value = "/all")
    public List<Tribe> GetTribes(){
        List<Tribe> tribes = tribeRepo.findAll();

        return tribes;
    }

    @PutMapping(value = "/create")
    public String CreateTribe(@RequestBody Tribe tribe){
        ObjectMapper m = new ObjectMapper();
        Response r = new Response("SUCCESS","TRIBE CREATED");
        this.tribeRepo.insert(tribe);

        try {
            return m.writeValueAsString(r);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR PARSING JSON";
        }
    }


    @RequestMapping(value = "/{id}")
    public String GetTribe(@PathVariable String id){
        return "FINDING TRIBE: " +  id;
    }

    public String UpdateTribe(){
        return "UPDATING TRIBE: ";
    }
}
