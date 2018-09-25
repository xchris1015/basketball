package io.chris.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PlayerInf")
public class PlayerInf {

    @Id
    //@GeneratedValue(strategy = SEQUENCE, generator= "users_id_seq")
    //@SequenceGenerator(name = "users_id_seq",sequenceName = "users_id_seq",allocationSize = 1)
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="position")
    private String position;

    @Column(name ="born")
    private String born;

    @Column(name ="height")
    private String height;

    @Column(name ="weight")
    private String weight;

    public PlayerInf(String firstName,String lastName,String position, String born,String height, String weight){
        this.firstName=firstName;
        this.lastName=lastName;
        this.position=position;
        this.born=born;
        this.height=height;
        this.weight=weight;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getBorn() {
        return born;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }



}
