package io.chris.training.core.domain;

import javax.persistence.*;

@Entity
@Table(name="player_statistics")
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "player_statistics_id_seq")
    @SequenceGenerator(name = "player_statistics_id_seq",sequenceName = "player_statistics_id_seq",allocationSize = 1)
    private Long id;

    @Column(name ="score")
    private Double score;

    @Column(name ="rebound")
    private Double rebound;

    @Column(name ="assistant")
    private Double assistant;

    @Column(name="steal")
    private Double steal;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Double getSteal() {
        return steal;
    }

    public void setSteal(Double steal) {
        this.steal = steal;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setRebound(Double rebound) {
        this.rebound = rebound;
    }

    public void setAssistant(Double assistant) {
        this.assistant = assistant;
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
