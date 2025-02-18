package com.codingcohorts.service;

import java.util.List;
import com.codingcohorts.dto.UserDTO;
import com.codingcohorts.dto.CreateUserDTO;
import com.codingcohorts.entity.User;
import com.codingcohorts.exception.ResourceNotFoundException;
import com.codingcohorts.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Initialize encoder
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return mapToDTO(user);

    }

    // New method to create a user
    public UserDTO createUser(CreateUserDTO createUserDTO) {

        User user = new User();
        user.setUsername(createUserDTO.username());
        user.setEmail(createUserDTO.email());
        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(createUserDTO.password());
        user.setPassword(hashedPassword);
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), List.of());
    }


    private UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPortfolios().stream().map(PortfolioService::mapToDTO).collect(toList())
        );
    }
}
