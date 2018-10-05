package io.chris.training.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="player_statistics")
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator= "users_id_seq")
    @SequenceGenerator(name = "users_id_seq",sequenceName = "users_id_seq",allocationSize = 1)
    private Long id;

    @Column(name ="score")
    private Double score;

    @Column(name ="rebound")
    private Double rebound;

    @Column(name ="assistant")
    private Double assistant;

    public PlayerStatistics(Double score,Double rebound, Double assistant){
        this.score=score;
        this.rebound=rebound;
        this.assistant=assistant;
    }

    public Long getId(){ return id; }

    public Double getScore() {
        return score;
    }

    public Double getRebound() {
        return rebound;
    }

    public Double getAssistant() {
        return assistant;
    }

}
