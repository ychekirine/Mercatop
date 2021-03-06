package com.mercatop.entities;

import com.mercatop.enums.Position;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;



@Entity
@Table
public class Player {

    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dob;

    @Transient
    private int age;
    private int height;
    //@Column (name= "weight")
    private int weight;
    private String picture;

    @ElementCollection(targetClass = Position.class)
    @Enumerated(EnumType.ORDINAL)
   /* @CollectionTable(name="player_positions")
    @Column(name="positions")*/

    private List<Position> pos;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Statistics> statisticsList;

    public Player() {

    }

    public Player(long id, String name, String lastName, String email, LocalDate dob, int age, int height, int weight, String picture, List<Position> pos, List<Statistics> statisticsList) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.picture = picture;
        this.pos = pos;
        this.statisticsList = statisticsList;
    }

    public Player(String name, String lastName, String email, LocalDate dob, int height, int weight, String picture, List<Position> pos, List<Statistics> statisticsList) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.picture = picture;
        this.pos = pos;
        this.statisticsList = statisticsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && age == player.age && height == player.height && weight == player.weight && Objects.equals(name, player.name) && Objects.equals(lastName, player.lastName) && Objects.equals(email, player.email) && Objects.equals(dob, player.dob) && Objects.equals(picture, player.picture) && Objects.equals(pos, player.pos) && Objects.equals(statisticsList, player.statisticsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, email, dob, age, height, weight, picture, pos, statisticsList);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Position> getPos() {
        return pos;
    }

    public void setPos(List<Position> pos) {
        this.pos = pos;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }
}
