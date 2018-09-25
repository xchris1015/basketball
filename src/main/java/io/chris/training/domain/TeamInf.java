package io.chris.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TeamInf")
public class TeamInf {

    @Id
    private Long Id; // how to match with User

    @Column(name ="conference")
    private String conference;

    @Column(name ="division")
    private String division;

    @Column(name ="found_year")
    private String foundYear;

    @Column(name ="history")
    private String history;

    @Column(name ="arena")
    private String arena;

    @Column(name ="location")
    private String location;

    public TeamInf(String conference,String division,String foundYear, String history,String arena, String location){
        this.conference=conference;
        this.division=division;
        this.foundYear=foundYear;
        this.history=history;
        this.arena=arena;
        this.location=location;
    }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public String getFoundYear() {
        return foundYear;
    }

    public String getHistory() {
        return history;
    }

    public String getArena() {
        return arena;
    }

    public String getLocation() {
        return location;
    }

}
