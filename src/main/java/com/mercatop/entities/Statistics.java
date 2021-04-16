package com.mercatop.entities;

import com.mercatop.enums.SeasonType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Statistics {

    @Id
    @SequenceGenerator(
            name = "statistics_sequence",
            sequenceName = "statistics_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "statistics_sequence"
    )
    private long id;

    private int goals;
    private int assists;
    private int redCards;
    private int yellowCards;
    private float rate;
    private int saves;
    private SeasonType seasonType;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public SeasonType getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(SeasonType seasonType) {
        this.seasonType = seasonType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return id == that.id && goals == that.goals && assists == that.assists && redCards == that.redCards && yellowCards == that.yellowCards && Float.compare(that.rate, rate) == 0 && saves == that.saves && seasonType == that.seasonType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goals, assists, redCards, yellowCards, rate, saves, seasonType);
    }
}
