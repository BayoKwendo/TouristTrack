package com.informatics.b254safaris.googleplaceapi.models;

public class Hotel {
    private String BookTitle, SHortDescription, URL;
    public Hotel() {
    }

    public Hotel(String BookTitle, String SHortDescription, String URL) {
        this.BookTitle = BookTitle;
        this.SHortDescription = SHortDescription;
        this.URL = URL;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookName) {
        this.BookTitle = BookTitle;


    }

    public String getShortDescription() {
        return SHortDescription;
    }

    public void setShortDescription(String shortdescription) {

        this.SHortDescription = SHortDescription;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

}


