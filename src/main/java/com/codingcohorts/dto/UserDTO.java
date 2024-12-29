package com.codingcohorts.dto;

import java.util.List;

public record UserDTO(Long id, String username, String email, List<PortfolioDTO> portFolios) {}

