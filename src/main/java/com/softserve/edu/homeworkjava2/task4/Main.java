package com.softserve.edu.homeworkjava2.task4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "Novel", 1960);
        Book book3 = new Book("The Great Gatsby", "Scott Fitzgerald", "Novel", 1925);
        Book book4 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir", "Matthew Perry", "Autobiography", 2022);
        Book book5 = new Book("Only Say Good Things: Surviving Playboy and Finding Myself", "Crystal Hefner", "Autobiography", 2024);
        Book book6 = new Book("Persuasion", "Jane Austen","Novel", 1817);
        Book book7 = new Book("Northanger Abbey","Jane Austen","Novel",1817);
        Book book8 = new Book("Sanditon", "Jane Austen","Novel", 1817);

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);

        Book book11 = new Book("aaaaa","Jane Austen","Novel",1820);
        Book book12 = new Book("bbbb","Jane Austen","Fantasy",1820);

        ArrayList<Book> secondCollection = new ArrayList<>();
        secondCollection.add(book11);
        secondCollection.add(book12);

        System.out.println("----Print List of Authors----");
        printAuthors(bookList);

        System.out.println("----List Authors by Genre----");
        printAuthorsByGenre(bookList, "Novel");

        System.out.println("----List Authors by Publication Year----");
        printAuthorsByPublishedYear(bookList, 1960);

        System.out.println("----Find Book by Author----");
        System.out.println(findBookByAuthor(bookList,"Crystal Hefner"));

        System.out.println("----Find Books by Publication Year----");
        System.out.println(findBooksByPublicationYear(bookList,1817));

        System.out.println("----Find Books by Genre----");
        System.out.println(findBooksByGenre(bookList, "Autobiography"));

        System.out.println("----Remove Books by Author----");
        System.out.println(bookList);
        removeAllBooksByAuthor(bookList,"Jane Austen");
        System.out.println(bookList);

        System.out.println("----Sort Collection by Author----");
        System.out.println(sortBooksByAuthor(bookList));

        System.out.println("----Merge Book Collections----");
        System.out.println(mergeCollections(bookList, secondCollection));

    }

    private static void printAuthors(List<Book> books) {
        System.out.println("All authors:");
        for (Book book : books) {
            System.out.println(book.getAuthor());
        }
    }

    private static void printAuthorsByGenre(List<Book> books, String genre) {
        books.stream()
            .filter(book -> book.getGenre().equalsIgnoreCase(genre))
            .map(Book::getAuthor)
            .distinct()
            .forEach(System.out::println);
    }

    private static void printAuthorsByPublishedYear(List<Book> books, int year) {
        books.stream()
            .filter(book -> book.getYear() == year)
            .map(Book::getAuthor)
            .distinct()
            .forEach(System.out::println);
    }

    private static Book findBookByAuthor(List<Book> books, String author) {
        return books.stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .findAny()
            .orElseThrow();
    }

    private static Collection<Book> findBooksByPublicationYear(List<Book> books, int year) {
        return books.stream()
            .filter(book -> book.getYear() == year)
            .toList();
    }

    private static Collection<Book> findBooksByGenre(List<Book> books, String genre) {
        return books.stream()
            .filter(book -> book.getGenre().equalsIgnoreCase(genre))
            .toList();
    }

    private static void removeAllBooksByAuthor(List<Book> books, String author) {
        books.removeIf(book -> book.getAuthor().equals(author));
    }

    private static Collection<Book> sortBooksByAuthor(List<Book> books) {
        return books.stream()
            .sorted(Comparator.comparing(Book::getAuthor))
            .toList();
    }

    private static Collection<Book> mergeCollections(Collection<Book> firstCollection, Collection<Book> secondCollection) {
        return Stream.concat(firstCollection.stream(), secondCollection.stream())
            .toList();
    }
}

