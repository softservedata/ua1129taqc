package com.softserve.edu.homework02;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BookCollection {

    List<String> authors = new ArrayList<>();
    List<Book> books = new ArrayList<>();

    public List<Book> getBookCollection() {

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

        for (Book book : books) {
            authors.add(book.getAuthor());
        }

        return  books;
    }

    public ArrayList<String> getAllAuthors () {
        ArrayList<String> authors = new ArrayList<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }

        System.out.println(authors);
        return authors;
    }

    public ArrayList<Book> getBooksByYear(int yearToFind) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        books = getBookCollection();
        for (Book book : books) {
            if (book.getYear() == yearToFind) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public Book getBookByAuthor(String author) {
        for (Book book : books) {
            String currentAuthor = book.getAuthor();
            if (currentAuthor.equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByAuthor(String author) {
        books = getBookCollection();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getAuthor() == author) {
                books.remove(book);
                i--;
            }
        }
    }



}
