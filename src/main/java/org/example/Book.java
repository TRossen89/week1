package org.example;

import java.time.LocalDate;

public class Book {

    private String title;
    private Double rating;
    private int numberOfPages;
    private String author;
    private int publicationYear;

    public Book(String title, Double rating, int numberOfPages, String author, int publicationYear) {
        this.title = title;
        this.rating = rating;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.publicationYear = publicationYear;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
