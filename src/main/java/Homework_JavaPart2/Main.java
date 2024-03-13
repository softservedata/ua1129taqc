package Homework_JavaPart2;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book.BookCollection books = new Book.BookCollection();
        books.addBook(new Book("title1", "author1", "genre1", 2020));
        books.addBook(new Book("title2", "author2", "genre2", 2012));
        books.addBook(new Book("title3", "author3", "genre3", 2009));
        books.addBook(new Book("title4", "author4", "genre2", 1992));

        System.out.println("Print List of Authors:");
        books.printListOfAuthors();
        System.out.println();

        System.out.println("List Authors by Genre:");
        ArrayList<String> authorsByGenre = books.listAuthorsByGivenGenre("genre2");
        for (String author : authorsByGenre) {
            System.out.println(author);
        }
        System.out.println();

        System.out.println("List Authors by Publication Year:");
        books.listAuthorsByPublicationYear(1992);
        System.out.println();

        System.out.println("Find Book by Author:");
        Book foundBook = books.bookByGivenAuthor("author1");
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found.");
        }
        System.out.println();

        System.out.println("Find Books by Publication Year:");
        ArrayList<Book> booksByYear = books.booksByGivenYear(2020);
        for (Book book : booksByYear) {
            System.out.println("Book: " + book.getTitle() + ", Year: " + book.getYear());
        }
        System.out.println();

        System.out.println("Find Books by Genre:");
        ArrayList<Book> booksByGenre = books.booksByGivenGenre("genre3");
        for (Book book : booksByGenre) {
            System.out.println("Book: " + book.getTitle() + ", Genre: " + book.getGenre());
        }
        System.out.println();

        System.out.println("Remove Books by Author:");
        books.removingSomeBooks("author4");
        books.printListOfAuthors();
        System.out.println();

        System.out.println("Sort Collection by Criterion:");
        books.sortCollectionByCriterion(Comparator.comparing(Book::getYear));
        books.printListOfAuthors();
        System.out.println();

        System.out.println("Merge Book Collections:");
        Book.BookCollection books2 = new Book.BookCollection();
        books2.addBook(new Book("title5", "author5", "genre5", 2005));
        books.combiningTwoBooks(books2);
        books.printListOfAuthors();
        System.out.println();

        System.out.println("Subcollection of Books by Genre:");
        ArrayList<Book> subcollection = books.subcollectionOfBooks("genre2");
        for (Book book : subcollection) {
            System.out.println("Book: " + book.getTitle() + ", Genre: " + book.getGenre());
        }
    }
}
