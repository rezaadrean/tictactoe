package com.tic.tac.toe.tictactoe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
public class NewController {

    @GetMapping("/test")
    public String test(){
        return "test ci cd";
    }
}
