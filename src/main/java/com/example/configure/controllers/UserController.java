package com.example.configure.controllers;

import com.example.configure.models.User;
import com.example.configure.models.UserDao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
            logger.warn("data insertion in process", user.getEmail(), user.getName());
            User userData = new User(user.getEmail(), user.getName());
            userDao.create(userData);
            logger.warn("data inserted successfully");

        } catch (Exception ex) {
            return "Error creating the user:" + ex.toString();
        }
        return "User Created successfully!";
    }
}
