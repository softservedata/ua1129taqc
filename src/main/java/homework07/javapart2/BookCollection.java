package homework07.javapart2;

/* Book Class Structure:
Fields: title (title), author (author), genre (genre), year (publication year).
Constructors: To initialize a book with all fields.
Getters/Setters: For accessing and modifying fields.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class BookCollection {
    private String title;
    private String author;
    private String genre;
    private int year;

    public BookCollection(String title, String author, String genre, int year) {
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


    public static void main(String[] args) {
        ArrayList<BookCollection> books = new ArrayList<>();
        books.add(new BookCollection("title1", "author1", "genre1", 2020));
        books.add(new BookCollection("title2", "author2", "genre2", 2012));
        books.add(new BookCollection("title3", "author3", "genre3", 2009));
        books.add(new BookCollection("title4", "author4", "genre2", 1992));

        // Print the list of all authors in the collection to the console.
        System.out.println("The list of all authors in the collection: ");
        for (BookCollection book : books) {
            System.out.println(book.getAuthor());
        }

        // Print the list of authors who have written books in a given genre.
        System.out.println("The list of authors who wrote books in a given genre: ");
        for (BookCollection book : books) {
            String genre = book.getGenre();
            String givenGenre = "genre2";
            if (genre.equals(givenGenre)) {
                System.out.println(book.getAuthor());
            }
        }

        // Print the list of authors whose books were published in a given year.
        for (BookCollection book : books) {
            int year = book.getYear();
            int givenYear = 2009;
            if (year == givenYear) {
                System.out.println("The list of authors whose books were published in " + givenYear + ": " + book.getAuthor());
            }
        }

        // Find a book in the collection written by a given author.
        for (BookCollection book : books) {
            String authors = book.getAuthor();
            String givenAuthor = "author3";
            if (authors.equals(givenAuthor)) {
                System.out.println("Book by " + givenAuthor + ": " + book.getTitle());
            }
        }

        // Find all books that were written in a given year.
        for (BookCollection book : books) {
            int year = book.getYear();
            int givenYear = 2012;
            if (year == givenYear) {
                System.out.println("Books that were written in " + givenYear + ": " + book.getTitle());
            }
        }

        // Find all books that belong to a given genre.
        for (BookCollection book : books) {
            String genre = book.getGenre();
            String givenGenre = "genre1";
            if (genre.equals(givenGenre)) {
                System.out.println("Books that belong to " + givenGenre + ": " + book.getTitle());
            }
        }

        // Remove from the collection all books written by a given author.
        System.out.println("The collection books after removing:");
        Iterator<BookCollection> booksIterator = books.iterator();
        String givenAuthor = "author3";
        while (booksIterator.hasNext()) {
            BookCollection book = booksIterator.next();
            String author = book.getAuthor();
            if (author.equals(givenAuthor)) {
                booksIterator.remove();
            }
        } for(BookCollection book : books){
            System.out.println(book.getTitle());
        }

        // Sort the book collection by a year of publication.
        System.out.println("The book collection after sorting:");
        ArrayList<Integer> sortedBooksByYear = new ArrayList<>();
        for (BookCollection book : books) {
            int year = book.getYear();
            sortedBooksByYear.add(year);
            Collections.sort(sortedBooksByYear);
        } for (Integer byYear : sortedBooksByYear) {
            System.out.println(byYear);
        }

        // Combine two book collections into one.
        System.out.println("Combining two book collections:");
        ArrayList<BookCollection> bookCollection2 = new ArrayList<>();
        bookCollection2.add(new BookCollection("newTitle", "newAuthor", "newGenre", 1995));
        books.addAll(bookCollection2);
        for (BookCollection book : books) {
            System.out.println(book.getAuthor());
        }

        // Create a subcollection of books from a given genre.
        System.out.println("A subcollection of books from a given genre:");
        ArrayList<BookCollection> genre2Books = new ArrayList<>();
        for (BookCollection book : books) {
            String genre = book.getGenre();
            String givenGenre = "genre2";
            if (genre.equalsIgnoreCase(givenGenre)) {
                genre2Books.add(book);
            }
        }for (BookCollection bookGenre2 : genre2Books) {
            System.out.println(bookGenre2.getTitle());
        }
    }
}

















