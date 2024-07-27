package org.example;
import org.example.Inventory.Library;
import org.example.Lending.Lends;
import org.example.books.Book;
import org.example.patrons.Patron;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        //We are creating the library
        Library library1= new Library();

        //Firstly we are doing declaration of books
        Book b1 = new Book("Harry Potter","J.K. Rowling","237-7649372100", 1998);
        Book b2 = new Book("Sherlock homes","Arthur Conan","978-0143455264",2002);
        Book b3 = new Book("The Hobbit","Douglas","965-876504332",2009);
        Book b4 = new Book("The Atomic Habits", "James Clear", "876-564439821", 2010);

        System.out.println("We are adding books in Library 1");
        //adding books in library
        library1.addBook(b1);
        library1.addBook(b2);
        library1.addBook(b3);
        library1.addBook(b4);

        //List of all available books in library
        System.out.println("\nList of all books in library 1");
        library1.listAvailableBooks();

        //we are adding Patrons
        Patron p1 = new Patron("Neil","AN123","neil@gmail.com","sector 122, Noida",90768567);
        Patron p2 = new Patron("Nitin","Nt476","nitin@gmail.com","yamuna nagar, sector148, delhi", 97548765);
        Patron p3 = new Patron("Mukesh","MK497","mukesh@gmail.com","Ashok Nagar, delhi",67438932);

        //Adding Patrons in library1
        library1.addPatron(p1);
        library1.addPatron(p2);
        library1.addPatron(p3);

        //Issue books to patrons
        Lends lend = new Lends();

        lend.lendBook(b1, p1, 20);   //we are issuing book b1 to p1 i.e. Harry Potter to Neil
        lend.lendBook(b2, p2, 10);
        lend.lendBook(b3, p1, 15);
        lend.lendBook(b2, p3, 10);
        lend.lendBook(b2, p1, 5);

        //List of all borrowed books after lending
        System.out.println("\nBorrowed books after lending in library1:");
        library1.listBorrowedBooks();

        System.out.println("\nList of all books available after lending:");
        library1.listAvailableBooks();

        //books borrowed by p1
        System.out.println("Books borrowed by " + p1.getName() + " with patronId " +  p1.getPatronID() + " are :");
        library1.getBooksBorrowedByPatron(p1.getPatronID());

        lend.returnBook(b1);  // Book b1 is retured by the patron who had this book
        lend.returnBook(b2);  //b2 book was reserved by p3  and p1 , So first notify p3 that now book b2 is available

        lend.lendBook(b2, p3, 10); // book b2 is lend to p3 as he was notified

        //List of All books Available after returning
        System.out.println("\n List of all books available after returning:");
        library1.listAvailableBooks();

        lend.returnBook(b2); // p1 will be notified as b2 was next reserved by p1
        lend.lendBook(b2, p1, 10); // book b2 is lend to p1 as he was notified
    }

}