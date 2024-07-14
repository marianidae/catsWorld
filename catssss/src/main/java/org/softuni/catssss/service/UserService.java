package org.softuni.catssss.service;

import org.softuni.catssss.model.dto.UserLoginDTO;
import org.softuni.catssss.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
