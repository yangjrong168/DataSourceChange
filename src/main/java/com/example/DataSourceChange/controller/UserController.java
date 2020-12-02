package com.example.DataSourceChange.controller;

import com.example.DataSourceChange.model.User;
import com.example.DataSourceChange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    public UserService userService;
    @GetMapping("/list")
    public List<User> list(){
        return userService.listAll();
    }
}
