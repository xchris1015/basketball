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
public class Players {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator= "users_id_seq")
    @SequenceGenerator(name = "users_id_seq",sequenceName = "users_id_seq",allocationSize = 1)
    private Long id;

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

    public Players(String firstName,String lastName,String playerPosition, Instant born,Double height, Double weight){
        this.firstName=firstName;
        this.lastName=lastName;
        this.playerPosition=playerPosition;
        this.born=born;
        this.height=height;
        this.weight=weight;
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