package io.chris.training.core.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public class User implements UserDetails, Serializable {

    public interface Registered_User{} //{} represent as class or implementation
    public interface Player extends Registered_User {}
    public interface Coach extends Player {}
    public interface Admin extends Coach {}

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

    @JsonView({JsView.Registered_User.class})
    @Column(name="email",unique = true)
//    @NotNull
    private String email;

    @Column(name="passwords")
    private String password;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user", cascade = CascadeType.ALL) //mapped by is mapped by instance name not sql column name, cascade.all provide the authorities to manage the foreign key object.
    @Transient
    private List<Authority> authority;

    @JsonIgnore
    @Column(name="create_at")
    private Instant createAt= Instant.now();


    @Column(name="phone_number")
    private String phoneNumber;

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

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

    @JsonView(Admin.class)
    public Long getId(){ return id; }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return this.authority; }

    public Collection<? extends GrantedAuthority> setAuthorities(List<Authority> authority){return this.authority=authority; }


    public String getUsername() {
        return this.username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}
