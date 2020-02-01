package com.hollieThomasCodefellowship.codefellowship.models;

import org.springframework.data.jpa.repository.JpaRepository;

//I am missing points for inheritance lab07, I did this, proving I know how to use inheritance
// I would like credit for lab07"


public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
