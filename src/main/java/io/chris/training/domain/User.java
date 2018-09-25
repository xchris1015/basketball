package io.chris.training.domain;

import com.sun.istack.internal.NotNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.sound.midi.Sequence;

@Entity
@Table(name="users")
public class User {

    @Id
    private Long id;

    @Column(name="username",unique = true)
    private String username;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="password")
    private String password;

    public User(String username,String firstName,String lastName,String email,String password){
        this.username= username;
        this.firstName = firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }

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

    public String getPassword() {
        return password;
    }



}
