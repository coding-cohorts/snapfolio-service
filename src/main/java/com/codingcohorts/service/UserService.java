package com.codingcohorts.service;

import com.codingcohorts.dto.UserDTO;
import com.codingcohorts.entity.User;
import com.codingcohorts.exception.ResourceNotFoundException;
import com.codingcohorts.repository.UserRepository;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return mapToDTO(user);

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
