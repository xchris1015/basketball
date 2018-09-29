//package io.chris.training.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="PlayerStatistics")
//public class PlayerStatistics {
//    @Id
//    //@GeneratedValue(strategy = SEQUENCE, generator= "users_id_seq")
//    //@SequenceGenerator(name = "users_id_seq",sequenceName = "users_id_seq",allocationSize = 1)
//    private Long id;
//
//    @Column(name ="first_name")
//    private String firstName;
//
//    @Column(name ="last_name")
//    private String lastName;
//
//    @Column(name ="player_position")
//    private String playerPosition;
//
//    @Column(name ="score")
//    private String score;
//
//    @Column(name ="rebound")
//    private String rebound;
//
//    @Column(name ="assistant")
//    private String assistant;
//
//    public PlayerStatistics(Long id,String firstName,String lastName,String playerPosition, String score,String rebound, String assistant){
//        this.firstName=firstName;
//        this.lastName=lastName;
//        this.playerPosition=playerPosition;
//        this.score=score;
//        this.rebound=rebound;
//        this.assistant=assistant;
//        this.id=id;
//    }
//
//    public Long getId(){ return id; }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getPlayerPosition() {
//        return playerPosition;
//    }
//
//    public String getScore() {
//        return score;
//    }
//
//    public String getRebound() {
//        return rebound;
//    }
//
//    public String getAssistant() {
//        return assistant;
//    }
//
//}
