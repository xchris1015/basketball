package io.chris.training.domain;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="team")
public class TeamInf {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator= "users_id_seq")
    @SequenceGenerator(name = "users_id_seq",sequenceName = "users_id_seq",allocationSize = 1)
    private Long id;

    @Column(name ="conference")
    private String conference;

    @Column(name ="division")
    private String division;

    @Column(name ="found_year")
    private Instant foundYear;

    @Column(name ="history")
    private String history;

    @Column(name ="arena")
    private String arena;

    @Column(name ="location")
    private String location;

    public TeamInf(String conference,String division,Instant foundYear, String history,String arena, String location){
        this.conference=conference;
        this.division=division;
        this.foundYear=foundYear;
        this.history=history;
        this.arena=arena;
        this.location=location;
    }

    public Long getId(){ return id; }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public Instant getFoundYear() {
        return foundYear;
    }

    public String getHistory() { return history; }

    public String getArena() {
        return arena;
    }

    public String getLocation() {
        return location;
    }

}
