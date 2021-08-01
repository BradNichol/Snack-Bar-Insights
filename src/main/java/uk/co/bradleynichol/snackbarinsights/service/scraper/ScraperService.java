package uk.co.bradleynichol.snackbarinsights.service.scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dto.ScraperResourceDTO;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;
import uk.co.bradleynichol.snackbarinsights.service.GenericService;
import uk.co.bradleynichol.snackbarinsights.service.ScraperResourceService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ScraperService {

    private static final Logger logger = LoggerFactory.getLogger(ScraperService.class);

    private final GenericService<ProductPrice> productPriceService;
    private final ScraperResourceService scraperResourceService;
    private final Scraper scraper;


    @Autowired
    public ScraperService(GenericService<ProductPrice> productPriceService, ScraperResourceService scraperResourceService, Scraper scraper) {
        this.productPriceService = productPriceService;
        this.scraperResourceService = scraperResourceService;
        this.scraper = scraper;
    }

    // @Scheduled(cron = "*/20 * * * * *" ) //-- requires correct cron schedule - TBC
    public void executeScraper() {

        logger.info("Scraping initiated.");

        List<ScraperResourceDTO> scraperResources = scraperResourceService.getAllResources();

        AtomicInteger success = new AtomicInteger();
        AtomicInteger failure = new AtomicInteger();

        scraperResources.forEach(resource -> {
            Double scrapedPrice = scraper.run(resource.getPath(), resource.getxPath());
            ProductPrice productPrice = getProductPrice(resource, scrapedPrice);
            if (scrapedPrice > 0) {
                success.getAndIncrement();
            } else {
                failure.getAndIncrement();
            }
            productPriceService.save(productPrice);
        });

        logger.info("Scrape Finished. Successful: {}. Failed: {}.", success, failure);
    }

    private ProductPrice getProductPrice(ScraperResourceDTO resource, Double price) {
        ProductPrice productPrice = new ProductPrice();
        productPrice.setProduct(resource.getProduct());
        productPrice.setPrice(price);
        return productPrice;
    }
}
