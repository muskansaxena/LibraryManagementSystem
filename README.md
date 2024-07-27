Library Management System :

This is a Library Management System in Java. This system is build to help librarians manage books, patrons and lending processes efficiently.

we have created diferent packages to easily understand and implement differents functionalities and follow design principles.

Main Functionalities
1. Book:
   we have books package inside that we have book java class.

   Functions of Book class:
        This class is used to define books in the library. 
   Attributes:

           title - String;
           author - String;
           ISBN - String;
           publicationYear - int;
           status - BookStatus;               
           reservationQueue - Queue<Patron>          // this queue is created to keep track of the patron who reserved this book first. we will notify the patron according to their position in the queue for particular book.

   BookStatus is an enum to check whether book is available or Borrowed
   enum BookStatus { AVAILABLE, BORROWED }

   Methods:
   
           isAvailable() : to check if book is available or borrowed.
           display() : to display book details.
           Constructors
           getters and setters
   
2. Patron
   we have a patrons package inside which we have Patron java class.

   Functions of Patron Class:
   This class is use to define different patrons in library. It also have borrowed books and borrow History info track for a patron. This info can be further use to build recomendation functionality for the patrons. This class also have a list of book which are marked as reserved by the patron as they were not available when he/she requested to borrow it.

    Attributes:
   
           name : String;
           patronID: String; //uniqueId
           emailId : String;
           address : String;
           phoneNumber: int;
           borrowedBooks : List<Book>; // to keep record of the books currently borrowed by patron
           borrowHistory : List<Book>; // to keep record of the books borrowed by the patron till now.
           reservations : List<Reservation> ; // to have record of all the books marked as reserved

   Methods:
   
           updateinfo() : to update info of the patron . note patron ID can't be changed.
           borrowBook() : to add all the books borrowed at present and in history in the borrowBooks and borrowHistory list in this class resp.
           returnBook() : to remove the retured book from borrowBooks list and mark the book as available.
           Constructor
           getters and setters

3. Lending
	This package contains all the functionalities invloved in lending a book to a patron.
	It has 2 classes i.e. Lends and Reservation

	Lends Class:
	to lend the book , return book , reserve book 
	
 	Attributes:

 		issueDate : Map<String, LocalDate> // to have issueDate associated with each bookId
		returnDate : Map<String ,LocalDate>	// to have returnDate associated with each bookId
		BookIssuedbyPatron : Map<String, Patron>	// to have patron who issued this book with the bookId provided as key in this map
		reservationMap : Map<String, List<<Reservation>> // to have reservation list corresponding to the bookID 

	Methods:

		lendBook() : to lend the book to the patron if book is available and if in reservationMap , remove it from there . If book is not available then reserveBook
		returnBook() : to return the book to the library if it was borrowed and notify patron in reservation Queue
		reserveBook() : to mark the book as reserved if it is not available and add it in book's reservation Queue
		notifyNextPatron() : to notify the next patron in the book reservation Queue that the book he/she had marked reserved is now avalable
		Constructors
		getters and setters

Reservation class:
		This class is used to create reservation List . This class is composed by lends class.

        Attributes:

   		bookISBN : String;
   		patronIID : String;
   		reservationDate : LocalDate;

        Methods:

   		Constructors
   		Getters
   
5. Inventory
   This package contains all the library Inventory functionalities.
   It has two interfaces BookManagement and InventoryManagement and these are implemented by class Library.

     BookManagement Interface:
	have all the operation related to books

		addBook();
   		removeBook();
   		updateBook();
   		searchBookbyTitle();
   		searchBookbyAuthor();
   		searchBookbyISBN();

     InventoryManagement Interface:

   		listAvailableBooks();
   		listBorrowedBooks();
   		getBooksBorrowedByPatron();

   Library Class :
   	composes books and patrons
	
 	Attributes :

		books : Map<String, Book>
		patrons : Map<String, Patron>

	Methods:

		Constructors
		getters and setters
		Interface methods
		addPatron();

