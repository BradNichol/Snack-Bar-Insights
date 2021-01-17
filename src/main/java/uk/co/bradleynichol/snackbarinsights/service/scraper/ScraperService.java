package uk.co.bradleynichol.snackbarinsights.service.scraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.entity.ProductPrice;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;
import uk.co.bradleynichol.snackbarinsights.service.IProductPriceService;
import uk.co.bradleynichol.snackbarinsights.service.IScraperResourceService;

import java.util.List;

@Service
public class ScraperService {

    private final IProductPriceService productPriceService;
    private final IScraperResourceService scraperResourceService;
    private final Scraper scraper;


    @Autowired
    public ScraperService(IProductPriceService productPriceService, IScraperResourceService scraperResourceService, Scraper scraper) {
        this.productPriceService = productPriceService;
        this.scraperResourceService = scraperResourceService;
        this.scraper = scraper;
    }

    //@Scheduled(cron = "*/20 * * * * *" ) -- requires correct cron schedule - TBC
    public void executeScraper() {
        List<ScraperResource> scraperResources = scraperResourceService.getAllResources();

        scraperResources.forEach(resource -> {
            Double scrapedPrice = scraper.run(resource.getPath(), resource.getxPath());
            ProductPrice productPrice = getProductPrice(resource, scrapedPrice);
            productPriceService.addProductPrice(productPrice);
        });
    }

    private ProductPrice getProductPrice(ScraperResource resource, Double price) {
        ProductPrice productPrice = new ProductPrice();
        productPrice.setProduct(resource.getProduct());
        productPrice.setPrice(price);
        return productPrice;
    }
}
