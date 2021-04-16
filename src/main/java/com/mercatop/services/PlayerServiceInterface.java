package com.mercatop.services;


import com.mercatop.entities.Player;

import java.util.List;

public interface PlayerServiceInterface {

    void addPlayer (Player player);
    List<Player> getPlayers();
    void deletePlayer(Long PlayerId);

}
