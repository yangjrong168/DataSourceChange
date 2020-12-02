package com.example.DataSourceChange.service;

import com.example.DataSourceChange.common.annotation.WhatDataSource;
import com.example.DataSourceChange.dao.UserDao;
import com.example.DataSourceChange.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    //@WhatDataSource(name = "slaveDataSource")
    public List<User> listAll(){
        return userDao.findAll();
    }
}
