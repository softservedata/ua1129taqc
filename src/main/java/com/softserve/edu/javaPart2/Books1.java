package com.softserve.edu.javaPart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Books1 {
    String title;
    String author;
    String genre;
    int year;

    public Books1(String title, String author, String genre, int year) {
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
        ArrayList<Books1> books = new ArrayList<>();
        books.add(new Books1("Cather in the Rye", "J. Sellinger", "Feature", 1965));
        books.add(new Books1("Frankenstein", "M. Shelly", "Fiction", 1889));
        books.add(new Books1("New Story", "T. Williams", "Fantasy", 2006));
        books.add(new Books1("American Horror Story", "K. McKenzey", "Detective", 2012));

        ArrayList<Books1> books2 = new ArrayList<>();
        books2.add(new Books1("Cather in the Rye", "J. Sellinger", "Feature", 1965));
        books2.add(new Books1("Frankenstein", "M. Shelly", "Fiction", 1889));
        books2.add(new Books1("New Story", "T. Williams", "Fantasy", 2006));
        books2.add(new Books1("American Horror Story", "K. McKenzey", "Detective", 2012));


        SortBooksByYear(books);


        System.out.println("Sorted collection by year:");
        for (Books1 book : books) System.out.println(book.getTitle() + " - " + book.getYear());

        var searchTitle = "book4";
        PrintAuthorForAGivenTitle(searchTitle, books);

        System.out.println("List of Authors who have written books in 1889:");
        for (Books1 book : books)
            if (book.getYear() == 1889) {
                System.out.println(book.getAuthor());
            }

        System.out.println("List of Authors who have written books in Fiction genre:");
        for (Books1 book : books)
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println(book.getAuthor());
            }

        System.out.println("List of Authors:");
        for (Books1 book : books) {
            System.out.println(book.getAuthor());


        }
    }

    private static void PrintAuthorForAGivenTitle(String title, ArrayList<Books1> books) {
        var author = GetAuthorByTitle(title, books);
        if (author == null) {
            System.out.println("Author not found");
        } else {
            System.out.println("Author who have written " + title + ":" + author);
        }
    }

    public static String GetAuthorByTitle(String title, ArrayList<Books1> books) {
        for (Books1 book : books)
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.getAuthor();
            }
        return null;
    }

    public static void SortBooksByYear(ArrayList<Books1> books) {
        Collections.sort(books, new Comparator<Books1>() {
            @Override
            public int compare(Books1 book1, Books1 book2) {
                return Integer.compare(book1.getYear(), book2.getYear());
            }
        });
    }

    public static ArrayList<Books1>
    GetCombinedCollection(ArrayList<Books1> books, ArrayList<Books1> books2) {
        ArrayList<Books1> combinedCollection = new ArrayList<>(books);
        combinedCollection.addAll(books2);
        return combinedCollection;
    }

    public static ArrayList<Books1>
    GetBooksByGenre(String givenGenre, ArrayList<Books1> books) {
        var subCollection = new ArrayList<Books1>();
        for (Books1 book : books) {
            if (book.getGenre().equalsIgnoreCase(givenGenre)) {
                subCollection.add(book);
            }
        }

        return subCollection;
    }
}
