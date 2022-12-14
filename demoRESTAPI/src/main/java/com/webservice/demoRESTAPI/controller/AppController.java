package com.webservice.demoRESTAPI.controller;

import org.springframework.web.bind.annotation.*;
import com.webservice.demoRESTAPI.model.RestUser;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/user")
public class AppController {
    Map<String , RestUser> allUsers = new HashMap<String, RestUser>();

    @GetMapping
    public Collection<RestUser> getCall(){

        return allUsers.values();
    }
    @PostMapping
    public String postCall(@RequestBody RestUser userDetails){
        RestUser addValue = new RestUser();

        addValue.setUserID(userDetails.getUserID());
        addValue.setUserFirstName(userDetails.getUserFirstName());
        addValue.setUserLastName(userDetails.getUserLastName());
        addValue.setUserEmail(userDetails.getUserEmail());
        allUsers.put(userDetails.getUserID(),addValue);
        return "Added!!";
    }
    @DeleteMapping(path = "/{userID}" )
    public String deleteCall(@PathVariable String userID){
        if(allUsers.containsKey(userID)){
            allUsers.remove(userID);
            return "User Has Been Removed !! ";
        }else {
            return "Invalid UserID";
        }
    }
    @PutMapping(path = "/{userID}" )
    public String putCall(@PathVariable String userID , @RequestBody RestUser userDetails){
        if(allUsers.containsKey(userID)){
            RestUser addValue = new RestUser();
            addValue.setUserID(userDetails.getUserID());
            addValue.setUserFirstName(userDetails.getUserFirstName());
            addValue.setUserLastName(userDetails.getUserLastName());
            addValue.setUserEmail(userDetails.getUserEmail());
            allUsers.put(userID,addValue);
            return "Modified Successfully";
        }else {
            return "Invalid UserID";
        }
    }
}