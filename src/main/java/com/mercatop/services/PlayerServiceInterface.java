package com.mercatop.services;


import com.mercatop.entities.Player;
import com.mercatop.entities.Statistics;
import com.mercatop.enums.Position;

import java.time.LocalDate;
import java.util.List;

public interface PlayerServiceInterface {

    void addPlayer (Player player);
    List<Player> getPlayers();
    void deletePlayer(Long PlayerId);

    Player getPlayer(Long playerId);
    Player updatePlayer(Player player);
}
