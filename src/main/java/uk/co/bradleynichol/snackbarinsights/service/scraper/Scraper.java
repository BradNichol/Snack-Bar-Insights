package uk.co.bradleynichol.snackbarinsights.service.scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Scraper {

    private static final Logger logger = LoggerFactory.getLogger(Scraper.class);

    public double run(String url, String priceXpath){
        WebClient webClient = new WebClient();
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        double price = 0.00;

        try {
            HtmlPage htmlPage = webClient.getPage(url);
            DomElement priceElement = htmlPage.getFirstByXPath(priceXpath);
            price = Double.parseDouble(priceElement.getTextContent()
                    .replace('£', ' ')
                    .trim());
        } catch (Exception e) {
            logger.error("Error with URL: {}, price XPath: {}", url, priceXpath);
            e.printStackTrace();
        } finally {
            webClient.close();
        }
        return price;
    }


}
