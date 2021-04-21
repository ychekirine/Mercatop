package com.mercatop.controllers;

import com.mercatop.entities.Player;
import com.mercatop.entities.Statistics;
import com.mercatop.enums.Position;
import com.mercatop.services.impl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path ="api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("all")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("find/{playerId}")
    public Player getPlayer(@PathVariable("playerId") Long playerId) {
        return playerService.getPlayer(playerId);
    }

    @PostMapping("/add")
    public void postPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }


    /// TODO : Check how to update
    /*@PutMapping ("/update/{playerId}")
    public void updatePlayer(
            @PathVariable("playerId") Long playerId,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String lastname,
            @RequestParam (required = false) String email,
            @RequestParam (required = false) LocalDate dob,
            @RequestParam (required = false) int height,
            @RequestParam (required = false) int weight,
            @RequestParam (required = false) List<Position> pos,
            @RequestParam (required = false) List<Statistics> statisticsList


    ){
        playerService.updatePlayer(playerId,name,lastname,email,dob,height,weight,pos,statisticsList);

    }*/

    @PutMapping ("/update")
    public Player updatePlayer(@RequestBody Player player){
        return playerService.updatePlayer(player);
    }

    @DeleteMapping(path = "delete/{playerId}")
    public void playerStudent(@PathVariable("playerId") Long playerId){
        playerService.deletePlayer(playerId);
    }


}
