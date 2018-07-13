package controllers;

import actions.TribeAddMember;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Tribe;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.TribeRepository;
import repository.UserRepository;
import tools.Response;

import java.util.List;

@RestController
@RequestMapping("/tribes")
public class TribeController {

    @Autowired
    TribeRepository tribeRepo;
    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/all")
    public List<Tribe> GetTribes(){
        List<Tribe> tribes = tribeRepo.findAll();
        return tribes;
    }

    @GetMapping(value = "/get/{id}")
    public String GetTribe(@PathVariable String id){
        Tribe single = tribeRepo.findTribeBy_Id(id);

        //Temporary for now until we can get our custom queries in order.
        if(single != null){
            return "<table><tr><td>"+single.getTitle()+"</td></tr><tr><td>"+single.getDescription()+"</td></tr><tr><td>"+single.getCreated()+"</td></tr><tr><td>"+single.getCreator().getUsername()+"</td></tr></table><h1>Members</h1><table><tr><td></td<</tr></table>";
        }else {
            return "<h1>Whoops, looks like that Tribe does not exist!</h1>";
        }
    }

    @PostMapping(value = "/add/member")
    public String AddTribeMember(@RequestBody TribeAddMember payload){
        Response r = new Response("SUCCESS","USER ADDED TO TRIBE");
        ObjectMapper m = new ObjectMapper();

        Tribe addedTo = tribeRepo.findTribeBy_Id(payload.tribe_id);

        if(payload.multi){
            List<User> users = userRepo.findUserList(payload.addedUsers);
            return "Adding to Tribe: "+addedTo.getTitle();
        }else{
            User newUser = userRepo.findMemberByStringId(payload.user_id);
            return "Adding "+newUser.getUsername()+" to Tribe: "+addedTo.getTitle();
        }
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

    @PostMapping(path = "/new/member")
    public String AddMember(@RequestBody User user){

        return "TEst working!";
    }

    @GetMapping(path = "/test/html")
    public String testHtml(){
        return "";
    }
}
