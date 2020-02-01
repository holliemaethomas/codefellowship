package com.hollieThomasCodefellowship.codefellowship.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;



    String username;
    String password;
    String firstname;
    String lastname;
    String bio;
    Date dateofbirth;

    public ApplicationUser(){};

    public ApplicationUser(String username, String password, String firstname,
                           String lastname, String bio,Date dateofbirth){
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bio = bio;
        this.dateofbirth = dateofbirth;
    }



}
