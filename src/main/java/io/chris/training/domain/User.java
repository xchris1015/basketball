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


    public void setUsername(String username){
        this.username=username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
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
