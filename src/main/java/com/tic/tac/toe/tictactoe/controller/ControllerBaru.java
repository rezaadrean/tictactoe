package com.tic.tac.toe.tictactoe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
public class ControllerBaru {

    @GetMapping("/testing")
    public String testing(){
        return "testing ci cd 2025";
    }
}
