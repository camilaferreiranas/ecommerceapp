package br.com.ecommerce.productapi.model;

public enum Category {


    SMARTPHONE("Smartphone"),
    DESKTOP("Desktop"),
    NOTEBOOK("Notebook");

    private String title;

    Category(String title) {
        this.title = title;
    }
}
