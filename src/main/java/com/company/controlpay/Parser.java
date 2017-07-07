package com.company.controlpay;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 07.07.17.
 */
public class Parser {
    private Doc doc = new Doc();
    Product product = new Product();
    List<Product> products = new ArrayList<>();
    public void getAllParameters(String keyWord) throws IOException {
        String sURL = String.format("http://rozetka.com.ua/search/?section_id=&section=&text=%s&rz-search-button=&producer=296&p=1", keyWord);
        dataFromPages(sURL);
    }

    private List<Product> dataFromPages(String sURL) throws IOException {
        Document document = doc.getDocument(sURL);
        Element review = document.select("div.detail-main-col-inner div.pp-g-rating-and-results meta").last();
        Element stars = document.select("div.detail-main-col-inner div.pp-g-rating-and-results meta").first();
        String reviewNumber = review.attr("content");
        String starsNumber = stars.attr("content");
        product.setStars(starsNumber);
        product.setReviews(reviewNumber);
        String divName = document.select("script").get(2).data();
        //TODO: refactor
        product.setPriceUSD(divName.substring(172, 176));
        product.setPrice(divName.substring(199, 202));
        System.out.println("PriceUSD " + product.getPriceUSD() + "  price " + product.getPrice() + " reviews " + product.getReviews() + " stars " + product.getStars());
        System.out.println("Correct stars number? " + isCorrectStarsNumber(starsNumber));
        System.out.println("Correct reviews number? " + isCorrectReviewsNumber(reviewNumber));
        return products;
    }

    private boolean isCorrectReviewsNumber(String reviewNumber){
        return reviewNumber.equals("49");
    }

    private boolean isCorrectStarsNumber(String starsNumber){
        return starsNumber.equals("5");
    }
}
