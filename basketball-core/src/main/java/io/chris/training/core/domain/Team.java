package io.chris.training.mvc.core.domain;

import javax.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name="team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "team_id_seq")
    @SequenceGenerator(name = "team_id_seq",sequenceName = "team_id_seq",allocationSize = 1)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    @Transient
    private List<Player> player;

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


    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setFoundYear(Instant foundYear) {
        this.foundYear = foundYear;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public void setLocation(String location) {
        this.location = location;
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
