package com.mercatop.services.impl;


import com.mercatop.entities.Player;
import com.mercatop.repositories.PlayerRepository;
import com.mercatop.services.PlayerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements PlayerServiceInterface {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void deletePlayer(Long playerId) {
        boolean exist = playerRepository.existsById(playerId);
        if(!exist){
            throw new IllegalStateException("playerID with id= " + playerId + " does not exists");
        }
        playerRepository.deleteById(playerId);

    }
}
