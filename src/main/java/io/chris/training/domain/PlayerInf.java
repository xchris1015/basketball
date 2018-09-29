//package io.chris.training.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="PlayerInf")
//public class PlayerInf {
//
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
//    @Column(name ="born")
//    private String born;
//
//    @Column(name ="height")
//    private String height;
//
//    @Column(name ="weight")
//    private String weight;
//
//    public PlayerInf(Long id,String firstName,String lastName,String playerPosition, String born,String height, String weight){
//        this.firstName=firstName;
//        this.lastName=lastName;
//        this.playerPosition=playerPosition;
//        this.born=born;
//        this.height=height;
//        this.weight=weight;
//        this.id=id;
//    }
//
//    public Long getId(){ return id; }
//
//    public String getFirstName() { return firstName; }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getPlayerPosition() {
//        return playerPosition;
//    }
//
//    public String getBorn() {
//        return born;
//    }
//
//    public String getHeight() {
//        return height;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
//
//
//
//}
