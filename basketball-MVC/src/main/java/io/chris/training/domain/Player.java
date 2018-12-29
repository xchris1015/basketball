package io.chris.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.GenerationType.SEQUENCE;/// ??? why this work

@Entity
@Table(name="players")
public class Player {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator= "players_id_seq")
    @SequenceGenerator(name = "players_id_seq",sequenceName = "players_id_seq",allocationSize = 1)
    private Long id;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "team_id")
//    private Team team;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="player_position")
    private String playerPosition;

    @Column(name ="born")
    private Instant born;

    @Column(name ="height")
    private Double height;

    @Column(name ="weight")
    private Double weight;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void setBorn(Instant born) {
        this.born = born;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getId(){ return id; }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public Instant getBorn() {
        return born;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }



}