package homework07.javapart2;

/* Book Class Structure:
Fields: title (title), author (author), genre (genre), year (publication year).
Constructors: To initialize a book with all fields.
Getters/Setters: For accessing and modifying fields.
 */

import java.util.*;


public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book (String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static class BookCollection {

        private ArrayList<Book> books;

        public BookCollection() {
            this.books = new ArrayList<>();
        }
        public void addBook (Book book) {
            books.add(book);
        }

        // Print the list of all authors in the collection to the console.
        public void printListOfAuthors() {
            for (Book book : books) {
                System.out.println(book.getAuthor());
            }
        }

        // Size collection
        public int sizeCollection (){
            return books.size();
        }

    // List of authors
        public ArrayList<String> getListOfAuthors() {
            ArrayList<String> authors = new ArrayList<>();
            for (Book book : books) {
                authors.add(book.getAuthor());
            }
            return authors;
        }

        // Print the list of authors who have written books in a given genre.
        public ArrayList<String> listAuthorsByGivenGenre(String givenGenre) {
            ArrayList<String> authorsList = new ArrayList<>();
            for (Book book : books) {
                String genre = book.getGenre();
                if (genre.equals(givenGenre)) {
                    authorsList.add(book.getAuthor());
                }
            }
            return authorsList;
        }

        // Print the list of authors whose books were published in a given year.
        public void listAuthorsByPublicationYear(int givenYear) {
            for (Book book : books) {
                int year = book.getYear();
                if (year == givenYear) {
                    System.out.println(book.getAuthor());
                }
            }
        }

        // Find a book in the collection written by a given author.
        public Book bookByGivenAuthor(String givenAuthor) {
            for (Book book : books) {
                String authors = book.getAuthor();
                if (authors.equalsIgnoreCase(givenAuthor)) {
                    return book;
                }
            } return null;
        }

        // Find all books that were written in a given year.
        public ArrayList<Book> booksByGivenYear(int givenYear) {
            ArrayList<Book> allBooks = new ArrayList<>();
            for (Book book : books) {
                int year = book.getYear();
                if (year == givenYear) {
                    allBooks.add(book);
                }
            }
            return allBooks;
        }

        // Find all books that belong to a given genre.
        public ArrayList<Book> booksByGivenGenre (String givenGenre){
            ArrayList<Book> allBooks = new ArrayList<>();
            for (Book book : books) {
                String genre = book.getGenre();
                if (genre.equalsIgnoreCase(givenGenre)) {
                    allBooks.add(book);
                }
            } return allBooks;
        }

        // Remove from the collection all books written by a given author.
        public void removingSomeBooks (String givenAuthor) {
            Iterator<Book> booksIterator = books.iterator();
            while (booksIterator.hasNext()) {
                Book book = booksIterator.next();
                String author = book.getAuthor();
                if (author.equals(givenAuthor)) {
                    booksIterator.remove();
                }
            } for (Book book : books) {
                System.out.println(book.getTitle());
            }
        }

        // Sort the book collection by a given criterion (e.g., title, author, or year of publication).
        public void sortCollectionByCriterion() {
            Comparator<Book> comparator = Comparator.comparing(Book::getYear);
            Collections.sort(books, comparator);
            for (Book book : books){
                System.out.println(book.getTitle() + " " + book.getYear());
            }
        }

        public ArrayList<Integer> getListOfYears() {
            ArrayList<Integer> years = new ArrayList<>();
            for (Book book : books) {
                years.add(book.getYear());
            }
            return years;
        }

        // Combine two book collections into one.
        public void combiningTwoBooks (BookCollection bookCollection2){
            this.books.addAll(bookCollection2.books);
            for (Book book : books){
                System.out.println(book.getTitle());
            }
        }

        // Create a subcollection of books from a given genre.
        public ArrayList<Book> subcollectionOfBooks (String givenGenre){
            ArrayList<Book> genre2Books = new ArrayList<>();
            for (Book book : books) {
                String genre = book.getGenre();
                if (genre.equalsIgnoreCase(givenGenre)) {
                    genre2Books.add(book);
                }
            } return genre2Books;
        }

    }


    public static void main(String[] args) {
        BookCollection books = new BookCollection();
        books.addBook(new Book ("title1", "author1", "genre1", 2020));
        books.addBook(new Book ("title2", "author2", "genre2", 2012));
        books.addBook(new Book ("title3", "author3", "genre3", 2009));
        books.addBook(new Book ("title4", "author4", "genre2", 1992));

        BookCollection books2 = new BookCollection();
        books2.addBook(new Book ("2title1", "2author1", "2genre2", 2001));
        books2.addBook(new Book("2title2", "2author2", "2genre2", 1998));

        // The list of all authors in the collection
        System.out.println("The list of all authors in the collection: ");
        books.printListOfAuthors();


        // The list of authors who have written books in genre2 genre.
        System.out.println("The list of authors who wrote books in a given genre: ");
        books.listAuthorsByGivenGenre("genre2");


        // The list of authors whose books were published in 1992.
        System.out.println("The list of authors whose books were published in given year: ");
        books.listAuthorsByPublicationYear(1992);


        // Book in the collection written by author1.
       Book findBook = books.bookByGivenAuthor("author1");
        System.out.println("Book written by a given author: " + "\n" + findBook.getTitle());


        // All books that were written in 2020.
        ArrayList<Book> findBooks = books.booksByGivenYear(2020);
        for (Book book : findBooks) {
            System.out.println("Books that were written in a given year: " + "\n" + book.getTitle());
        }


        // All books that belong to genre3 genre.
        ArrayList<Book> booksByGivenGenre = books.booksByGivenGenre("genre3");
        for (Book book : booksByGivenGenre) {
            System.out.println("Books that belong to a given genre: " + "\n" + book.getTitle());
        }

        // The collection after removing all books written by author4.
        System.out.println("The collection books after removing:");
        books.removingSomeBooks("author4");


        // Sorting collection by a year of publication.
        System.out.println("The book collection after sorting: ");
        books.sortCollectionByCriterion();

        // Combining two book collections into one.
        System.out.println("Combining two book collections: ");
        books.combiningTwoBooks(books2);

        // Subcollection of books from genre2 genre.
        ArrayList<Book> subcollection = books.subcollectionOfBooks("genre2");
        for (Book book : subcollection) {
            System.out.println("A subcollection of books from a given genre:" + "\n" + book.getTitle());
        }

    }
}

















