package com.nuitdelinfo.app.users.controller;

import com.nuitdelinfo.app.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService service;

    
}
