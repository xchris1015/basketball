package io.chris.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PlayerStatistics")
public class PlayerStatistics {
    @Id
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="position")
    private String position;

    @Column(name ="score")
    private String score;

    @Column(name ="rebound")
    private String rebound;

    @Column(name ="assistant")
    private String assistant;

    public PlayerStatistics(String firstName,String lastName,String position, String score,String rebound, String assistant){
        this.firstName=firstName;
        this.lastName=lastName;
        this.position=position;
        this.score=score;
        this.rebound=rebound;
        this.assistant=assistant;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getScore() {
        return score;
    }

    public String getRebound() {
        return rebound;
    }

    public String getAssistant() {
        return assistant;
    }

}
