package org.example.patrons;
import org.example.Lending.Reservation;
import org.example.books.Book;

import java.util.ArrayList;
import java.util.List;


public class Patron{
    //Attributes
    private String name;
    private String patronID;
    private String emailId;
    private String address;
    private int phoneNumber;
    private List<Book> borrowedBooks;
    private List<Book> borrowHistory;
    private List<Reservation> reservations;

    //Constructors
    public Patron(String name, String patronID, String emailId, String address, int phoneNumber) {
        this.name = name;
        this.patronID = patronID;
        this.emailId = emailId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
        this.borrowHistory = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronID() {
        return patronID;
    }

    public void setPatronID(String patronID) {
        this.patronID = patronID;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getBorrowHistory() {
        return borrowHistory;
    }

    public void setBorrowHistory(List<Book> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }

    public List<Reservation> getReservations(){
        return reservations;
    }

    //Method to update patron information
    public void updateInfo(String emailId, String address, int phoneNumber){
        this.emailId = emailId;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    //Method to borrow a book
    public void borrowBook(Book book){
        if (book.isAvailable()) { // there can be multiple books of same name and type
            borrowedBooks.add(book);
            borrowHistory.add(book);
            book.setStatus(Book.BookStatus.BORROWED);
        }
        else {
            System.out.println("Book is currently not available for borrowing");
        };
    }

    //Method to return a book
    public void returnBook(Book book){
        if (borrowedBooks.contains(book)){
            borrowedBooks.remove(book);
            book.setStatus(Book.BookStatus.AVAILABLE);
        }
        else{
            System.out.println("This book is not borrowed by Patron " + this.getName());
        }
    }

}
