package com.mercatop.repositories;

import com.mercatop.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {


    Optional<Player> findPlayerByEmail(String email);
}
