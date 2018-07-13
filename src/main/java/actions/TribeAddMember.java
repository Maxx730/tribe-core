package actions;

import models.User;

import java.util.List;

public class TribeAddMember {
    public String tribe_id,user_id;

    //We want to be able to add multiple users to a Tribe at least
    //for when the tribe is first created.
    public boolean multi = false;
    public List<User> addedUsers[];
}
