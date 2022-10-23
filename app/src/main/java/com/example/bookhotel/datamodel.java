package com.example.bookhotel;

public class datamodel {
    int image;
    String book,type;

    public datamodel(int image, String book, String type) {
        this.image = image;
        this.book = book;
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
