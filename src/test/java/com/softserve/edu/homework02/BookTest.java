package com.softserve.edu.homework02;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookTest {

    private static BookCollection myBookCollection;

    @BeforeAll
    public static void setup() {
        myBookCollection = new BookCollection();
    }

    @Test
    public void checkSize() {
        myBookCollection = new BookCollection();
        List<Book> actualCollection = myBookCollection.getBookCollection();
        Assertions.assertEquals(5, actualCollection.size());
    }

    @Test
    public void checkAuthor() {
        List<Book> actualCollection = myBookCollection.getBookCollection();
        String authorToFind = "Alan J Richardson";
        for (Book book : actualCollection) {
            if (book.getAuthor() == authorToFind) {
                Assertions.assertEquals(authorToFind, book.getAuthor());
            } else {
                Assertions.assertNotEquals(authorToFind, book.getAuthor());
            }
        }
    }

    @Test
    void getListOfAuthors() {
        ArrayList<String> authors = myBookCollection.getAllAuthors();
        Assertions.assertEquals(List.of("Alan J Richardson", "Kristin Jackvony", "Erin Meyer",
                "Gayathri Mohan", "Paul C. Jorgensen"), authors);
    }

    @Test
    void getBooksByPublicationYear(){
        ArrayList<Book> booksByYear = myBookCollection.getBooksByYear(2022);

        ArrayList<String> expectedBooks = new ArrayList<>(Arrays.asList("Full Stack Testing: A Practical Guide for Delivering High Quality Software",
                "Software Testing: A Craftsman's Approach"));

        ArrayList<String> foundTitles = new ArrayList<>();

        for (Book book : booksByYear){
            foundTitles.add(book.getTitle());
        }

        Assertions.assertEquals(expectedBooks, foundTitles);
    }

    @Test
    void removeByAuthor() {
        myBookCollection.removeBookByAuthor("Paul C. Jorgensen");
        Assertions.assertNull(myBookCollection.getBookByAuthor("Paul C. Jorgensen"));
    }
}
