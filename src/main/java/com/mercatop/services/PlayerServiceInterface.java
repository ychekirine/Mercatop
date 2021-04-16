package com.mercatop.services;


import com.mercatop.entities.Player;

import java.util.List;

public interface PlayerServiceInterface {

    public void addPlayer (Player player);
    public List<Player> getPlayers();
    public void deletePlayer(Long PlayerId);
}
