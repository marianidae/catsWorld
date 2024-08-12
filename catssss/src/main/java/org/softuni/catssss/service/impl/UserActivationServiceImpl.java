package org.softuni.catssss.service.impl;


import org.softuni.catssss.model.event.UserRegisteredEvent;
import org.softuni.catssss.service.EmailService;
import org.softuni.catssss.service.UserActivationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final EmailService emailService;

    public UserActivationServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {

        emailService.sendRegistrationEmail(event.getUserEmail(),
                event.getUserNames());
    }


}
