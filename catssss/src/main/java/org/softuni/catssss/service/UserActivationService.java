package org.softuni.catssss.service;


import org.softuni.catssss.model.event.UserRegisteredEvent;

public interface UserActivationService {

    void userRegistered(UserRegisteredEvent event);

//    void cleanUpObsoleteActivationLinks();
//
    String createActivationCode(String userEmail);
}
