package com.mercatop.controllers;

import com.mercatop.entities.Player;
import com.mercatop.services.impl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public void postPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @DeleteMapping(path = "{playerId}")
    public void playerStudent(@PathVariable("playerId") Long studentId){
        playerService.deletePlayer(studentId);
    }




}
