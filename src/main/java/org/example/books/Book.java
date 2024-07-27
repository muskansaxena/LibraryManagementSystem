package org.example.books;

import org.example.patrons.Patron;

import java.util.LinkedList;
import java.util.Queue;

public class Book {
    //Attributes
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;
    private BookStatus status;
    private Queue<Patron> reservationQueue;

    public enum BookStatus {
        AVAILABLE,
        BORROWED
    }

    //Constructor
    public Book(String title, String author, String ISBN, int publicationYear){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;
        this.reservationQueue = new LinkedList<>();
    }

    //Getters and Setters
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public int getPublicationYear(){
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }

    public BookStatus getStatus(){
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Queue<Patron> getReservationQueue() {
        return reservationQueue;
    }

    //Method to check if book is available or not
    public boolean isAvailable(){
        return this.status == BookStatus.AVAILABLE;
    }

    public void display(){
        System.out.println("Book title:" + title);
        System.out.println("Book author:" + author);
        System.out.println("Book ISBN: " + ISBN);
        System.out.println("Book Publication year:" + publicationYear + "\n");
    }

}
