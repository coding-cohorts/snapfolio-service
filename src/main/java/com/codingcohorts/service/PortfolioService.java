package com.codingcohorts.service;

import com.codingcohorts.dto.PortfolioDTO;
import com.codingcohorts.entity.Portfolio;
import com.codingcohorts.exception.ResourceNotFoundException;
import com.codingcohorts.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    private final PortfolioRepository portFolioRepository;

    PortfolioService(PortfolioRepository portFolioRepository) {
        this.portFolioRepository = portFolioRepository;
    }

    public PortfolioDTO getPortfolio(Long id) {
        Portfolio portfolio = portFolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id: " + id));
        return mapToDTO(portfolio);
    }

    public static PortfolioDTO mapToDTO(Portfolio portfolio) {
        return new PortfolioDTO(
                portfolio.getId(),
                portfolio.getTitle(),
                portfolio.getTheme(),
                portfolio.getAbout(),
                portfolio.getWorkExperience(),
                portfolio.getProjects(),
                portfolio.getEducation(),
                portfolio.getSkills()
        );
    }
}
