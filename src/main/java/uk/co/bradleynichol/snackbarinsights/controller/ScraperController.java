package uk.co.bradleynichol.snackbarinsights.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.bradleynichol.snackbarinsights.service.scraper.ScraperService;

@Hidden
@RestController
@RequestMapping("/api/scraper")
public class ScraperController {

    private final ScraperService scraperService;

    @Autowired
    public ScraperController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @GetMapping("/run")
    public ResponseEntity<String> runScraper() {
        new Thread(scraperService::executeScraper).start();
        return new ResponseEntity<>("Scraper executed", HttpStatus.ACCEPTED);
    }
}
