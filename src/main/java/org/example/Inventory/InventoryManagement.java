package org.example.Inventory;

import org.example.books.Book;

import java.util.List;

public interface InventoryManagement {

    public void listAvailableBooks();

    public void listBorrowedBooks();

    public void getBooksBorrowedByPatron(String patronId);
}
