package com.codingcohorts.controller;

import com.codingcohorts.dto.PortfolioDTO;
import com.codingcohorts.service.PortfolioService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PortFolioController {

    private final PortfolioService portFolioService;

    public PortFolioController(PortfolioService portFolioService) {
        this.portFolioService = portFolioService;
    }

    @GetMapping(value = "/portfolio/{portfolio_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PortfolioDTO getPortfolio(@PathVariable Long portfolio_id) {
        return portFolioService.getPortfolio(portfolio_id);
    }
   // create a method which will return list of portfolios belonging to a particular user
}
