package com.codingcohorts.dto;

public record PortfolioDTO(
        Long id,
        String title,       // Portfolio title
        String theme,       // Theme (e.g., "dark", "light")
        String about,       // About Me section
        String workExperience, // Work Experience details
        String projects,    // Projects details
        String education,   // Education details
        String skills       // Skills (JSON array or comma-separated string)
) {}


