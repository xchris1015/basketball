package io.chris.training.domain;


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
    private String password;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
//    @Transient
    private List<Authority> authority;

    @Column(name="create_at")
    private Instant createAt;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId(){ return id; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return this.authority; }

    public Collection<? extends GrantedAuthority> setAuthorities(List<Authority> authority){return this.authority=authority; }

    @Override
    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

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

    public String getPasswords() {
        return password;
    }



}
