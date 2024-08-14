package org.softuni.catssss.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.softuni.catssss.model.dto.UserRegistrationDTO;
import org.softuni.catssss.model.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserEntityMapperTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMapUserRegistrationDTOToUserEntity() {
        // Arrange
        UserRegistrationDTO dto = mock(UserRegistrationDTO.class);
        when(dto.firstName()).thenReturn("John");
        when(dto.lastName()).thenReturn("Doe");
        when(dto.email()).thenReturn("john.doe@example.com");
        when(dto.password()).thenReturn("password123");

        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");

        // Act
        UserEntity userEntity = map(dto);

        // Assert
        assertNotNull(userEntity);
        assertFalse(userEntity.isActive(), "Active should be false by default");
        assertEquals("John", userEntity.getFirstName());
        assertEquals("Doe", userEntity.getLastName());
        assertEquals("john.doe@example.com", userEntity.getEmail());
        assertEquals("encodedPassword", userEntity.getPassword());

        verify(passwordEncoder, times(1)).encode("password123");
    }

    // The map method to be tested
    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(false)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
    }
}
