package model;

import javax.swing.*;

public class BookModel {

int bookId;
String title;
String author;
String genre;
String isbn;
int publicationYear;
int price;
int stockQuantity;

public BookModel(){

}
public BookModel(int bookId, String title, String author, String genre, String isbn, int publicationYear, int price, int stockQuantity){

    this.bookId=bookId;
    this.title=title;
    this.author=author;
    this.genre=genre;
    this.isbn=isbn;
    this.publicationYear=publicationYear;
    this.price=price;
    this.stockQuantity=stockQuantity;
}
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public static class MyRowFilter extends RowFilter {

        private final String searchText;

        public MyRowFilter(String searchText) {
            this.searchText = searchText;
        }

        @Override
        public boolean include(Entry entry) {
            return entry.getStringValue(0).indexOf(searchText) >= 0;

        }
    }
}


