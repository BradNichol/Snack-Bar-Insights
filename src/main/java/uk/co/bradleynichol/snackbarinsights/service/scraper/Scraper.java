package uk.co.bradleynichol.snackbarinsights.service.scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Scraper {

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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
        return price;
    }


}
