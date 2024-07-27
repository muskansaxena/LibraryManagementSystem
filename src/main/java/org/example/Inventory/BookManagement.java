package org.example.Inventory;

import org.example.books.Book;

import java.util.List;
import java.util.stream.Collectors;

public interface BookManagement {

    //add a book to library
    public void addBook(Book book);

    //Remove a book from the library
    public void removeBook(String ISBN);

    //Update book details
    public void updateBook(Book book);

    public List<Book> searchBookByTitle(String title);

    //Search for a book by author
    public List<Book> searchBookByAuthor(String author);

    //search for a book by ISBN
    public Book searchBookByISBN(String isbn);

}
