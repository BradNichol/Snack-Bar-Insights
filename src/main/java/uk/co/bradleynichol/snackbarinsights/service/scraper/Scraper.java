package uk.co.bradleynichol.snackbarinsights.service.scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;


public class Scraper {

    public void run(String url, String titleXpath, String priceXpath){
        WebClient webClient = new WebClient();
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage(url);
            DomElement productName = htmlPage.getFirstByXPath(titleXpath);
            System.out.println(productName.getTextContent().trim());

            DomElement price = htmlPage.getFirstByXPath(priceXpath);
            System.out.println(price.getTextContent().trim());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }


    }


}
