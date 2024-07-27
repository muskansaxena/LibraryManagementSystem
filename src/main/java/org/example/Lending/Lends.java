package org.example.Lending;
import org.example.books.Book;
import org.example.patrons.Patron;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lends{

    //Attributes
    private Map<String ,LocalDate> issueDate;
    private Map<String,LocalDate> returnDate;
    private Map<String, Patron> BookIssuedbyPatron;         // will have bookId and patron having that book
    private Map<String, List<Reservation>> reservationMap;

    //Constructor

    public Lends(){
        this.issueDate = new HashMap<>();
        this.returnDate = new HashMap<>();
        this.BookIssuedbyPatron = new HashMap<>();
        this.reservationMap = new HashMap<>();
    }

    //Getters and setters

    public Map<String, LocalDate> getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Map<String, LocalDate> issueDate) {
        this.issueDate = issueDate;
    }

    public Map<String, LocalDate> getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Map<String, LocalDate> returnDate) {
        this.returnDate = returnDate;
    }

    public Map<String, Patron> getBookIssuedbyPatron() {
        return BookIssuedbyPatron;
    }

    public void setBookIssuedbyPatron(Map<String, Patron> bookIssuedbyPatron) {
        BookIssuedbyPatron = bookIssuedbyPatron;
    }

    //Method to lend the book
    public void lendBook(Book book, Patron patron, int days){
        if (book.isAvailable()){
            issueDate.put(book.getISBN(), LocalDate.now());
            returnDate.put(book.getISBN(), issueDate.get(book.getISBN()).plusDays(days));
            patron.borrowBook(book);
            book.getReservationQueue().remove(patron);
            BookIssuedbyPatron.put(book.getISBN(), patron);
            System.out.println("Book " + book.getTitle()+ " is issued by " + patron.getName() + " on " + issueDate.get(book.getISBN()) + " till " + returnDate.get(book.getISBN()));
        }
        else {
            System.out.println("Book " + book.getTitle() + " with bookId " + book.getISBN() + " is not available.");
            if (reserveBook(book, patron));
                System.out.println("Book " + book.getTitle() + " with bookId " +  book.getISBN() + " is reserved by " + patron.getName() + " with patronId " + patron.getPatronID());
        }
        //can also print next available date of this book
    }

    //Method to return a book
    public void returnBook(Book book){
        if (!book.isAvailable()) {
            Patron patron = BookIssuedbyPatron.get(book.getISBN());
            patron.returnBook(book);
            this.BookIssuedbyPatron.remove(book.getISBN());
            this.issueDate.remove(book.getISBN());
            this.returnDate.remove(book.getISBN());
            System.out.println("Book " + book.getTitle() + " is returned");
            notifyNextPatron(book);
        }
        else
            System.out.println("This book is not issued by anyone and is still available");
    }

    public boolean reserveBook(Book book, Patron patron){
        if (book != null && patron != null) {
            List<Reservation> reservations = reservationMap.getOrDefault(book.getISBN(), new ArrayList<>());
            Reservation reservation = new Reservation(book.getISBN(), patron.getPatronID());
            reservations.add(reservation);
            reservationMap.put(book.getISBN(), reservations);
            book.getReservationQueue().add(patron);
            patron.getReservations().add(reservation);
            return true;
        }
        return false;
    }

    public void notifyNextPatron(Book book){
        List<Reservation> reservations = reservationMap.get(book.getISBN());
        if (reservations != null && !reservations.isEmpty()){
            Reservation nextReservation = reservations.removeFirst();
            Patron p = book.getReservationQueue().peek();

            System.out.println("Notify " + p.getName()+ " having PID " + p.getPatronID() + " that book " + book.getTitle()+ " with bookid " + book.getISBN() + " is available");
        }
    }
}
