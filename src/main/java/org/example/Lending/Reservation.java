package org.example.Lending;

import java.time.LocalDate;

public class Reservation {
    //Attributes
    private String bookISBN;
    private String patronID;
    private LocalDate reservationDate;

    //Constructor
    public Reservation(String bookISBN, String patronID){
        this.bookISBN = bookISBN;
        this.patronID = patronID;
        this.reservationDate = LocalDate.now();
    }

    //Getters
    public String getBookISBN() {
        return bookISBN;
    }

    public String getPatronID() {
        return patronID;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

}
