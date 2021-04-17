package com.mercatop.config;

import com.mercatop.entities.Player;
import com.mercatop.entities.Statistics;
import com.mercatop.enums.Position;
import com.mercatop.enums.SeasonType;
import com.mercatop.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner (PlayerRepository playerRepository){
        return args -> {
            Player youcef = new Player(
                    "youcef",
                    "Chekirine",
                    "youcef.chekirine@gmail.com",
                    LocalDate.of(1996, Month.AUGUST, 4),
                    165,
                    55,
                    List.of(Position.FORWARDS),
                    List.of(new Statistics(
                            55,
                            43,
                            0,
                            5,
                            8.3,
                            0,
                            SeasonType.CHAMPIONS_LEAGUE))
            );

            Player aissa = new Player(
                    "Aissa",
                    "Benhamida",
                    "aissa.benhami@gmail.com",
                    LocalDate.of(1996, Month.OCTOBER, 10),
                    180,
                    75,
                    List.of(Position.DEFENDERS),
                    List.of(new Statistics(
                            5,
                            2,
                            25,
                            58,
                            7.3,
                            0,
                            SeasonType.CHAMPIONS_LEAGUE))
            );

            playerRepository.saveAll(List.of(youcef,aissa));

        };
    }
}

