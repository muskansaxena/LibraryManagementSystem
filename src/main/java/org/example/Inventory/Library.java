package org.example.Inventory;

import org.example.Lending.Reservation;
import org.example.books.Book;
import org.example.patrons.Patron;

import java.util.*;
import java.util.stream.Collectors;

public class Library implements BookManagement, InventoryManagement{

    private Map<String, Book> books;
    private Map<String, Patron> patrons;

    //Constructor
    public Library(){
        this.books = new HashMap<>();
        this.patrons = new HashMap<>();
    }

    //Add a book to the Library
    public void addBook(Book book){
        books.put(book.getISBN(), book);
    }
    //Remove a book from the library
    public void removeBook(String ISBN){
        if (books.containsKey(ISBN)){
            books.remove(ISBN);
        }
        else
            System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    //Update book details
    public void updateBook(Book book){
        String isbn = book.getISBN();
        if (books.containsKey(isbn)){
            books.put(isbn, book);
        }
        else
            System.out.println("Book with ISBN " + isbn + " not found.");
    }

    //Search for a book by title
    public List<Book> searchBookByTitle(String title){
        return books.values().stream().filter(book->book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    //Search for a book by author
    public List<Book> searchBookByAuthor(String author){
        return books.values().stream().filter(book->book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    //search for a book by ISBN
    public Book searchBookByISBN(String isbn){
        if (books.containsKey(isbn)){
            return books.get(isbn);
        }
        else
            System.out.println("Book with ISBN " + isbn + " not found.");
        return null;
    }

    public void addPatron(Patron patron){
        patrons.put(patron.getPatronID(), patron);
    }

    //List all available books
    public void listAvailableBooks(){
        for(String isbn: books.keySet()){
            Book b = books.get(isbn);
            if (b.isAvailable())
                b.display();
        }
        System.out.println("*************************");
    }

    //list all borrowed books
    public void listBorrowedBooks(){
        for(String isbn: books.keySet()){
            Book b = books.get(isbn);
            if (!b.isAvailable())
                b.display();
        }
    }

    //Methods to get books borrowed by a specific patron
    public void getBooksBorrowedByPatron(String patronId){
         Patron patron = patrons.get(patronId);
         if (patron != null){
            for(Book book1 : patron.getBorrowedBooks())
                book1.display();
        }
         else
             System.out.println("No books borrowed");
    }
}