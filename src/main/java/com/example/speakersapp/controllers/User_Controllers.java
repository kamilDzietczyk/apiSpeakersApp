package com.example.speakersapp.controllers;


import com.example.speakersapp.model.User;
import com.example.speakersapp.repo.UserRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class User_Controllers {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @RequestMapping("/usersList")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public User get (@PathVariable Long id){
        return userRepository.getById(id);
    }

    @PostMapping("/UserEquals")
    public JSONObject EqualsUser(@RequestBody JSONObject jsonObject1){
        List<User> list = userRepository.findAll();
        JSONObject jsonObject = new JSONObject();
        for(int i=0;i<=list.size()-1;i++){
            if(list.get(i).getUser_password().equals(jsonObject1.get("user_password")) && list.get(i).getUser_name().equals(jsonObject1.get("user_name"))){
                jsonObject.put("user_id", list.get(i).getUser_id());
                jsonObject.put("user_login", list.get(i).getUser_name());
                jsonObject.put("user_role", list.get(i).getUser_role());
            }
        }
        return jsonObject;
    }

    @PostMapping
    @RequestMapping("/addUser")
    public JSONObject createUser(@RequestBody final User user){
        List<User> list = userRepository.findAll();
        int exist = 0;
        JSONObject jsonObject = new JSONObject();
        for(int i=0;i<=list.size()-1;i++){
            if(list.get(i).getUser_name().equals(user.getUser_name())){
                exist++;
            }
        }
        if(exist == 0){
            System.out.println();
            userRepository.saveAndFlush(user);
            jsonObject.put("User: ","is add");
        }else{
            jsonObject.put("User: ","exist");
        }
        userRepository.saveAndFlush(user);
        return jsonObject;
    }

    @DeleteMapping
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user){
        User existingSession = userRepository.getById(id);
        BeanUtils.copyProperties(user,existingSession,"user_id");
        return userRepository.saveAndFlush(existingSession);
    }
}
