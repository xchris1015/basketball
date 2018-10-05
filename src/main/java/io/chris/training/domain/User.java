package io.chris.training.domain;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.sound.midi.Sequence;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator= "users_id_seq")
    @SequenceGenerator(name = "users_id_seq",sequenceName = "users_id_seq",allocationSize = 1)
    private Long id;

    @Column(name="username",unique = true)
//    @NotNull
    private String username;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
//    @NotNull
    private String lastName;

    @Column(name="email",unique = true)
//    @NotNull
    private String email;

    @Column(name="passwords")
    private String passwords;

    public User(String username,String firstName,String lastName,String email,String passwords){
        this.username= username;
        this.firstName = firstName;
        this.lastName=lastName;
        this.email=email;
        this.passwords=passwords;
    }

    public Long getId(){ return id; }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswords() {
        return passwords;
    }



}
