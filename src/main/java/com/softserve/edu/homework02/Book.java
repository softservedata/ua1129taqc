package com.softserve.edu.homework02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    @Override
    public String toString() {
        return "Book{" +
                "title = \"" + title + "\"; " +
                "author = " + author + "; " +
                "genre = " + genre + "; " +
                ", year= " + year +
                '}';
    }

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("Java For Testers: Learn Java fundamentals fast", "Alan J Richardson",
                "Programming", 2015));
        books.add(new Book("The Complete Software Tester: Concepts, Skills, and Strategies for High-Quality Testing",
                "Kristin Jackvony", "Software Testing", 2021));
        books.add(new Book("The Culture Map: Decoding How People Think, Lead, and Get Things Done Across Cultures",
                "Erin Meyer", "Psychology", 2016));
        books.add(new Book("Full Stack Testing: A Practical Guide for Delivering High Quality Software",
                "Gayathri Mohan", "Programming", 2022));
        books.add(new Book("Software Testing: A Craftsman's Approach", "Paul C. Jorgensen",
                "Software Testing", 2022));

        //Print all books
        System.out.println("All books in the collection:");
        for (Book book : books) {
                System.out.println("\t" + book.toString());
            }

        System.out.println("----------------------------------------------------------------------------------------");

        //Print List of Authors
        System.out.println("The list of authors:");
        for (Book book : books) {
            System.out.println("\t" + book.getAuthor().toString());
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //List Authors by Genre
        String genreToFind = "Software Testing";
        System.out.println("The list of authors by genre (" + genreToFind + "):");
        for (Book book : books) {
            if (book.getGenre() == genreToFind) {
                System.out.println("\t" + book.getAuthor().toString());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //List Authors by Publication Year
        int yearToFind = 2022;
        System.out.println("Authors who published books in " + yearToFind + ":");
        for (Book book : books) {
            if (book.getYear() == yearToFind) {
                System.out.println("\t" + book.getAuthor().toString());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //Find Book by Author
        String authorToFind = "Kristin Jackvony";
        System.out.println("Books written by " + authorToFind + ":");
        for (Book book : books) {
            if (book.getAuthor() == authorToFind) {
                System.out.println("\t" + book.getTitle().toString());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //Find Books by Publication Year
        System.out.println("Books published in " + yearToFind + ":");
        for (Book book : books) {
            if (book.getYear() == yearToFind) {
                System.out.println("\t" + book.getTitle().toString());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //Find Books by Genre
        System.out.println("The list of books by genre (" + genreToFind + "):");
        for (Book book : books) {
            if (book.getGenre() == genreToFind) {
                System.out.println("\t" + book.getTitle().toString());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //Sort Collection by year
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book m1, Book m2) {
                return (int) (m1.getYear() - m2.getYear());
            }
        });

        System.out.println("Sorted collection of books (by year of publication):");
        for (Book book : books) {
            System.out.println("\t" + book.toString());
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //Sub-collection of Books by Genre
        System.out.println("Sub-collection of books by genre (" + genreToFind + "):");
        List<Book> booksSubCollection = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == genreToFind) {
                booksSubCollection.add(book);
            }
        }
        for (Book book : booksSubCollection) {
            System.out.println("\t" + book.toString());
        }

        System.out.println("----------------------------------------------------------------------------------------");

        //Merge Book Collections
        System.out.println("Merging two collections of books:");

        List<Book> booksToMerge = new ArrayList<>();

        booksToMerge.add(new Book("Hands-on Selenium Webdriver With Java", "Boni Garcia",
                "Programming", 2022));
        booksToMerge.add(new Book("Head First Java: A Brain-Friendly Guide",
                "Kathy Sierra", "Programming", 2022));
        booksToMerge.add(new Book("Test Automation Fundamentals: A Study Guide",
                "Manfred Baumgartner", "Programming", 2022));

        List<Book> booksBackup = new ArrayList(books);

        books.removeAll(booksToMerge);

        books.addAll(booksToMerge);

        for (Book book : books) {
            System.out.println("\t" + book.getTitle().toString());
            }

        System.out.println("----------------------------------------------------------------------------------------");

        //Remove Books by Author
        System.out.println("Removed Books by Author (" + authorToFind + "):");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getAuthor() == authorToFind) {
                books.remove(book);
                i--;
            }
        }

        for (Book book : books) {
            System.out.println("\t" + book.getTitle().toString());
        }


    }

}
