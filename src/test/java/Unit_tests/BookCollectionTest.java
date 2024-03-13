package Unit_tests;

import Homework_JavaPart2.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookCollectionTest {



    @Test
    public void testListAuthorsByGivenGenre() {
        Book.BookCollection books = new Book.BookCollection();
        books.addBook(new Book("title1", "author1", "genre1", 2020));
        books.addBook(new Book("title2", "author2", "genre2", 2012));
        books.addBook(new Book("title3", "author3", "genre3", 2009));
        assertEquals(1, books.listAuthorsByGivenGenre("genre1").size());
    }



    @Test
    public void testBookByGivenAuthor() {
        Book.BookCollection books = new Book.BookCollection();
        books.addBook(new Book("title1", "author1", "genre1", 2020));
        books.addBook(new Book("title2", "author2", "genre2", 2012));
        Book foundBook = books.bookByGivenAuthor("author1");
        assertNotNull(foundBook);
        assertEquals("title1", foundBook.getTitle());
    }

    @Test
    public void testBooksByGivenYear() {
        Book.BookCollection books = new Book.BookCollection();
        books.addBook(new Book("title1", "author1", "genre1", 2020));
        books.addBook(new Book("title2", "author2", "genre2", 2012));
        books.addBook(new Book("title3", "author3", "genre3", 2020));
        assertEquals(2, books.booksByGivenYear(2020).size());
    }

    @Test
    public void testBooksByGivenGenre() {
        Book.BookCollection books = new Book.BookCollection();
        books.addBook(new Book("title1", "author1", "genre1", 2020));
        books.addBook(new Book("title2", "author2", "genre2", 2012));
        books.addBook(new Book("title3", "author3", "genre1", 2020));
        assertEquals(2, books.booksByGivenGenre("genre1").size());
    }


}
