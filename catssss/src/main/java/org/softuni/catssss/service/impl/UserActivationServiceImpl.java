package org.softuni.catssss.service.impl;


import org.softuni.catssss.model.entity.UserActivationCodeEntity;
import org.softuni.catssss.model.event.UserRegisteredEvent;
import org.softuni.catssss.repository.UserActivationCodeRepository;
import org.softuni.catssss.repository.UserRepository;
import org.softuni.catssss.service.EmailService;
import org.softuni.catssss.service.UserActivationService;
import org.softuni.catssss.service.exception.ObjectNotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private static final String ACTIVATION_CODE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";

    private static final int ACTIVATION_CODE_LENGTH = 20;
    private final EmailService emailService;

    private final UserRepository userRepository;

    private final UserActivationCodeRepository userActivationCodeRepository;



    public UserActivationServiceImpl(EmailService emailService, UserRepository userRepository, UserActivationCodeRepository userActivationCodeRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {

        String activationCode = createActivationCode(event.getUserEmail());
        emailService.sendRegistrationEmail(event.getUserEmail(),
                event.getUserNames(),
                activationCode);
    }

    public String createActivationCode(String userEmail) {

        String activationCode = generateActivationCode();

        UserActivationCodeEntity userActivationCodeEntity = new UserActivationCodeEntity();
        userActivationCodeEntity.setActivationCode(activationCode);
        userActivationCodeEntity.setCreated(Instant.now());
        userActivationCodeEntity.setUser(userRepository.findByEmail(userEmail).orElseThrow(() -> new ObjectNotFoundException("User not found")));

        userActivationCodeRepository.save(userActivationCodeEntity);

        return activationCode;

    }

    private static String generateActivationCode() {

        StringBuilder activationCode = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int randInx = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randInx));
        }

        return activationCode.toString();
    }


}
