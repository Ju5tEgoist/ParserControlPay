package com.company.controlpay;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by yulia on 07.07.17.
 */
    @XmlRootElement(name = "products")
    @XmlType(propOrder = {"name", "price", "stars", "reviews",  "priceUSD"})
    public class Product {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public String getReviews() {
            return reviews;
        }

        public void setReviews(String reviews) {
            this.reviews = reviews;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPriceUSD() {
            return priceUSD;
        }

        public void setPriceUSD(String priceUSD) {
            this.priceUSD = priceUSD;
        }

        public Product() {
        }

        public Product(String name, String stars, String price, String priceUSD, String reviews) {
            this.name = name;
            this.stars = stars;
            this.reviews = reviews;
            this.price = price;
            this.priceUSD = priceUSD;
        }

        private String name;
        private String stars;
        private String reviews;
        private String price;
        private String priceUSD;
    }
