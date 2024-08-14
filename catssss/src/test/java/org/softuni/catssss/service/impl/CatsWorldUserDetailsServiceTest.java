package org.softuni.catssss.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.softuni.catssss.model.entity.UserEntity;
import org.softuni.catssss.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CatsWorldUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CatsWorldUserDetailsService userDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsername_UserExists() {
        // Arrange
        String email = "john.doe@example.com";
        UserEntity mockUserEntity = new UserEntity();
        mockUserEntity.setEmail(email);
        mockUserEntity.setFirstName("John");
        mockUserEntity.setLastName("Doe");
        mockUserEntity.setPassword("hashedPassword"); // Set a non-null password

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(mockUserEntity));

        // Act
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        // Assert
        assertNotNull(userDetails, "UserDetails should not be null");
        assertEquals(email, userDetails.getUsername(), "Usernames should match");
        assertEquals("hashedPassword", userDetails.getPassword(), "Passwords should match");
        // Add other assertions if necessary
    }

    @Test
    public void testLoadUserByUsername_UserDoesNotExist() {
        // Arrange
        String email = "unknown@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Act & Assert
        UsernameNotFoundException thrown = assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(email);
        });

        assertEquals("User " + email + " not found!", thrown.getMessage(), "Exception message should match");
    }


}
