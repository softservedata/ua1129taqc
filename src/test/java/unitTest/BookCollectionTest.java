package unitTest;

import homework07.javapart2.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BookCollectionTest {

private static Book.BookCollection books;
private static Book.BookCollection books2;

    @BeforeEach
        void  array1 () {
        books = new Book.BookCollection();
        books.addBook(new Book("title1", "author1", "genre1", 2012));
        books.addBook(new Book("title2", "author2", "genre2", 2012));
        books.addBook(new Book("title3", "author3", "genre3", 1890));
    }

        static void array2 (){
        books2 = new Book.BookCollection();
        books2.addBook(new Book("1title", "1author", "1genre", 1998));
        books2.addBook(new Book("2title", "2author", "2genre", 2024));
    }

    @Test
    void testCheckSizeCollection (){
        int size = books.sizeCollection();
        Assertions.assertEquals(3, size);
    }

    @Test
    void testPrintListOfAuthors (){
        ArrayList<String> authors = books.getListOfAuthors();
        Assertions.assertEquals(List.of("author1", "author2", "author3"), authors);
    }

    @Test
    void testPrintAuthorsByGenre(){
        ArrayList<String> authors = books.listAuthorsByGivenGenre("genre2");
        ArrayList<String> expectedAuthors = new ArrayList<>(Arrays.asList("author2"));
        Assertions.assertEquals(expectedAuthors,authors);
    }

    @Test
    void testFindBookByAuthor(){
        Book book  = books.bookByGivenAuthor("author3");
        Assertions.assertEquals("title3", book.getTitle());
    }

    @Test
    void testFindBooksByYear(){
        ArrayList<Book> booksByYear = books.booksByGivenYear(2012);
        ArrayList<String> expectedBooks = new ArrayList<>(Arrays.asList("title1", "title2"));
        ArrayList<String> actualTitles = new ArrayList<>();
        for (Book book : booksByYear){
            actualTitles.add(book.getTitle());
        } Assertions.assertEquals(expectedBooks, actualTitles);
    }

    @Test
    void testFindBooksByGenre (){
        ArrayList<Book> booksByGenre = books.booksByGivenGenre("genre3");
        ArrayList<String> expectedBooks = new ArrayList<>(Arrays.asList("title3"));
        ArrayList<String> actualTitles = new ArrayList<>();
        for (Book book : booksByGenre){
            actualTitles.add(book.getTitle());
        } Assertions.assertEquals(expectedBooks, actualTitles);
    }

    @Test
    void testRemoveBooksByAuthor(){
        books.removingSomeBooks("author2");
        Assertions.assertNull(books.bookByGivenAuthor("author2"));
    }

    @Test
    void testSortCollectionByYear(){
        books.sortCollectionByCriterion();
        ArrayList<Integer> sortedByYear = books.getListOfYears();
        ArrayList<Integer> expectedYears = new ArrayList<>(Arrays.asList(1890, 2012, 2012));
        Assertions.assertEquals(expectedYears, sortedByYear);
    }

    }



