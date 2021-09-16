package com.neoris.support.services;

import com.neoris.support.controllers.TurnController;
import com.neoris.support.entities.Turn;
import com.neoris.support.exceptions.CreateTurnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turns")
public class TurnService {

    @Autowired
    TurnController turnController;

    @PostMapping("/create")
    public Turn createTurn (@RequestParam String document){
        try{
            return this.turnController.createTurn(document);
        }
        catch(CreateTurnException ex){
            ex.printStackTrace(System.out);
            return null;
        }
    }
    @PostMapping("/attend/{n}/{document}")
    public String attendCustomer(@PathVariable Integer n, @PathVariable String document){
        try{
            return this.turnController.changeTurnStatus(n,document);
        }
        catch(CreateTurnException ex){
            ex.printStackTrace(System.out);
            return null;
        }
    }
}
