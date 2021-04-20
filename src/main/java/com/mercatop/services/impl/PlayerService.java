package com.mercatop.services.impl;


import com.mercatop.entities.Player;
import com.mercatop.entities.Statistics;
import com.mercatop.enums.Position;

import com.mercatop.services.PlayerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mercatop.repositories.PlayerRepository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements PlayerServiceInterface {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void addPlayer(Player player) {
        if (player.getPicture() == null || player.getPicture().equals("")){
            player.setPicture("https://www.handiclubnimois.fr/wp-content/uploads/2020/10/blank-profile-picture-973460_1280.png");
        }
        playerRepository.save(player);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(Long playerId) {
        boolean exist = playerRepository.existsById(playerId);
        if(!exist){
            throw new IllegalStateException("playerID with id= " + playerId + " does not exists");
        }
        return playerRepository.findById(playerId).get();
    }

    @Override
    public void deletePlayer(Long playerId) {
        boolean exist = playerRepository.existsById(playerId);
        if(!exist){
            throw new IllegalStateException("playerID with id= " + playerId + " does not exists");
        }
        playerRepository.deleteById(playerId);

    }

    @Override
    public Player updatePlayer(Player player){
        return playerRepository.save(player);
    }

    /*@Transactional
    @Override
    public void updatePlayer(Long playerId, String name,String lastname, String email, LocalDate dob, int height, int weight, List<Position> pos, List<Statistics> statisticsList) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("the player with id: " + playerId + " does not exists"));

        if (name != null && name.length() >0 && !player.getName().equals(name)){
            player.setName(name);
        }

        if (lastname != null && lastname.length() >0 && !player.getLastname().equals(lastname)){
            player.setLastname(lastname);
        }

        if (email != null && email.length() >0 && !player.getEmail().equals(email)){
            Optional<Player> optionalPlayer = playerRepository.findPlayerByEmail(email);
            if(optionalPlayer.isPresent()){
                throw new IllegalStateException("email taken");
            }
            player.setEmail(email);
        }

        ///TODO : For others fields dob,height, weight, pos, and stats

        */


}

