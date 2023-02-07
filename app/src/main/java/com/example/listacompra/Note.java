package com.example.listacompra;

public class Note {
    private String title;
    private String description;
    private String quantity;

    public Note() {
    }

    public Note(String title, String description, String quantity) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }
}
