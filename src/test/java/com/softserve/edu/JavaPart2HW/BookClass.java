package com.softserve.edu.JavaPart2HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BookClass {
    String title;
    String author;
    String genre;
    int year;

    public BookClass(String title, String author, String genre, int year) {
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
        // Create a collection of books
        ArrayList<BookClass> books = new ArrayList<>();
        books.add(new BookClass("Book1", "Author1", "Fiction", 2000));
        books.add(new BookClass("Book2", "Author2", "Non-fiction", 2010));
        books.add(new BookClass("Book3", "Author1", "Fantasy", 2015));
        books.add(new BookClass("Book4", "Author3", "Science", 2005));

        ArrayList<BookClass> books2 = new ArrayList<>();
        books2.add(new BookClass("Book1", "Author1", "Fiction", 2000));
        books2.add(new BookClass("Book2", "Author2", "Non-fiction", 2010));
        books2.add(new BookClass("Book3", "Author1", "Fantasy", 2015));
        books2.add(new BookClass("Book4", "Author3", "Science", 2005));


        SortBooksByYear(books);


        System.out.println("Sorted collection by year:");
        for (BookClass book : books) System.out.println(book.getTitle() + " - " + book.getYear());

        var searchTitle = "book4";
        PrintAuthorForAGivenTitle(searchTitle, books);

        System.out.println("List of Authors who have written books in 2015:");
        for (BookClass book : books)
            if (book.getYear()==2015) {
                System.out.println(book.getAuthor());
            }

        System.out.println("List of Authors who have written books in Fiction genre:");
        for (BookClass book : books)
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println(book.getAuthor());
            }

        System.out.println("List of Authors:");
        for (BookClass book : books) {
            System.out.println(book.getAuthor());



        }
    }

    private static void PrintAuthorForAGivenTitle(String title, ArrayList<BookClass> books) {
        var author = GetAuthorByTitle(title, books);
        if (author == null)
        {
            System.out.println("Author not found");
        }
        else {
            System.out.println("Author who have written " + title + ":" + author);
        }
    }

    public static String GetAuthorByTitle(String title, ArrayList<BookClass> books){
        for (BookClass book : books)
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getAuthor();
            }
        return null;
    }
    public static void SortBooksByYear(ArrayList<BookClass> books)
    {
        Collections.sort(books, new Comparator<BookClass>() {
            @Override
            public int compare(BookClass book1, BookClass book2) {
                return Integer.compare(book1.getYear(), book2.getYear());
            }
        });
    }

    public static ArrayList<BookClass>
    GetCombinedCollection(ArrayList<BookClass> books, ArrayList<BookClass> books2) {
        ArrayList<BookClass> combinedCollection = new ArrayList<>(books);
        combinedCollection.addAll(books2);
        return combinedCollection;
    }

    public static ArrayList<BookClass>
    GetBooksByGenre(String givenGenre, ArrayList<BookClass> books) {
        var subCollection = new ArrayList<BookClass>();
        for (BookClass book : books) {
            if (book.getGenre().equalsIgnoreCase(givenGenre)) {
                subCollection.add(book);
            }
        }

        return subCollection;
    }
}