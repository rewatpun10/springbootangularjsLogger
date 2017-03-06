package com.example.configure.controllers;

import com.example.configure.models.User;
import com.example.configure.models.UserDao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by rewat on 11/30/16.
 */
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserDao userDao;

    /**
     * creates a new user with an auto generated id and email and username
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestBody User user) {
        try {
            logger.info("user insertion in process" + user.getEmail() + user.getName());
            User userData = new User(user.getEmail(), user.getName());
            userDao.create(userData);
            logger.info("user with name " + user.getName() + " inserted successfully");

        } catch (Exception ex) {
            return "Error creating the user:" + ex.toString();
        }
        return "User Created successfully!";
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public  User read(@RequestParam Long userId) {
        User user = userDao.getById(userId);
        return user;
    }
}
