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
                    "Youcef",
                    "Chekirine",
                    "youcef.chekirine@gmail.com",
                    LocalDate.of(1996, Month.AUGUST, 4),
                    165,
                    55,
                    "https://resize-parismatch.lanmedia.fr/img/var/news/storage/images/paris-match/people-a-z/lionel-messi/6071756-4-fre-FR/Lionel-Messi.jpg",
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
                    "https://media-exp1.licdn.com/dms/image/C4E03AQH8JDWjzJe4mA/profile-displayphoto-shrink_200_200/0/1579076648086?e=1622678400&v=beta&t=_3K-ku2hIlQGur-eh9o7IEoHzt856NRtfxS9HxneY3A",
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

