package com.hollieThomasCodefellowship.codefellowship.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String username;

    String password;
    String firstname;
    String lastname;
    String bio;
    Date dateofbirth;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "follow_flow",
            joinColumns = { @JoinColumn(name = "follower_id") },
            inverseJoinColumns = { @JoinColumn(name = "following_id") }
    )
    List<ApplicationUser> usersIfollow;

    @ManyToMany
            (mappedBy = "usersIfollow")
    List<ApplicationUser> usersFollowedMe;

    public ApplicationUser(){}


    public ApplicationUser(String username,
                           String encode,
                           String firstName,
                           String lastName,
                           java.sql.Date dateOfBirth,
                           String bio){};

    public ApplicationUser(String username, String password, String firstname,
                           String lastname, String bio, Date dateofbirth){
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
        this.dateofbirth = dateofbirth;
    }


    public List<Post> getPosts(){
        return this.posts;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public Date getDateofbirth(){
        return dateofbirth;
    }

    public String getBio(){
        return bio;
    }

//    stolen from demo
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){

        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }


    public Long getId() {
        return id;
    }

    public List<ApplicationUser> getUsersIfollow() {
        return usersIfollow;
    }

    public List<ApplicationUser> getUsersFollowedMe() {
        return usersFollowedMe;
    }
}


//got help from demo, also used this article // https://www.baeldung.com/hibernate-many-to-many
