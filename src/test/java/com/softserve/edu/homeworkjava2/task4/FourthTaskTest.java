package com.softserve.edu.homeworkjava2.task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.softserve.edu.homeworkjava2.task4.FourthTask.*;
import static org.junit.jupiter.api.Assertions.*;


public class FourthTaskTest {

    @Test
    public void findBookByAuthor_should_return_book_if_several_books_with_author_exists_in_collection() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Sanditon", "Jane Austen","Novel", 1817);
        Book book3 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2, book3);

        // when
        Book foundBook = findBookByAuthor(books, "Jane Austen");

        // then
        assertTrue(foundBook.equals(book1) || foundBook.equals(book2));
    }

    @Test
    public void findBookByAuthor_should_return_book_if_one_book_with_author_exists_in_collection() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2);

        // when
        Book foundBook = findBookByAuthor(books, "Jane Austen");

        // then
        assertEquals(foundBook, book1);
    }

    @Test
    public void findBookByAuthor_should_return_book_with_author_ignoring_case() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2);

        // when
        Book foundBook = findBookByAuthor(books, "jane austen");

        // then
        assertEquals(foundBook, book1);
    }

    @Test
    public void findBookByAuthor_should_throw_exception_if_book_with_author_not_present_in_collection() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2);

        // when
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> findBookByAuthor(books, "Some author")
        );

        // then
        assertEquals("Collection is empty", exception.getMessage());
    }

    @Test
    public void findBooksByPublicationYear_should_return_correct_list_of_found_books() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book3 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2, book3);
        List<Book> expected = List.of(book2, book1);

        // when
        Collection<Book> foundBooks = findBooksByPublicationYear(books, 1813);

        // then
        assertEquals(expected.size(), foundBooks.size());
        assertTrue(expected.containsAll(foundBooks));
    }

    @Test
    public void findBooksByPublicationYear_should_return_empty_list_of_books_if_books_not_found() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2);

        // when
        Collection<Book> foundBooks = findBooksByPublicationYear(books, 2024);

        // then
        assertTrue(foundBooks.isEmpty());
    }

    @Test
    public void findBooksByGenre_should_return_correct_list_if_several_books_with_this_genre_exists_in_collection() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Sanditon", "Jane Austen","Novel", 1817);
        Book book3 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2, book3);
        List<Book> expected = List.of(book1, book2);

        // when
        Collection<Book> foundBooks = findBooksByGenre(books, "Novel");

        // then
        assertEquals(expected.size(), foundBooks.size());
        assertTrue(expected.containsAll(foundBooks));
    }

    @Test
    public void findBooksByGenre_should_return_correct_list_if_one_book_with_this_genre_exists_in_collection() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book1, book2);
        List<Book> expected = List.of(book1);

        // when
        Collection<Book> foundBook = findBooksByGenre(books, "Novel");

        // then
        assertEquals(expected.size(), foundBook.size());
        assertTrue(expected.containsAll(foundBook));
    }

    @Test
    public void findBooksByGenre_should_return_book_correct_list_ignoring_case() {
        // given
        Book book1 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);
        Book book2 = new Book("Sanditon", "Jane Austen","Novel", 1817);

        List<Book> books = List.of(book1, book2);
        List<Book> expected = List.of(book2);

        // when
        Collection <Book> foundBook = findBooksByGenre(books, "novel");

        // then
        assertEquals(expected.size(), foundBook.size());
        assertTrue(expected.containsAll(foundBook));
    }

    @Test
    public void removeAllBooksByAuthor_should_return_correct_collection_without_passed_author() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Sanditon", "Jane Austen","Novel", 1817);
        Book book3 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir","Matthew Perry", "Autobiography", 2022);

        List<Book> books = new ArrayList<>(List.of(book1, book2, book3));
        List<Book> expected = List.of(book3);


        // when
        removeAllBooksByAuthor(books,"Jane Austen");

        // then
        assertEquals(books.size(), expected.size());
        assertTrue(expected.containsAll(books));
    }

    @Test
    public void sortBooksByAuthor_should_return_sort_collection_by_author() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Sanditon", "Jane Austen", "Novel", 1817);
        Book book3 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir", "Matthew Perry", "Autobiography", 2022);

        List<Book> books = List.of(book3, book1, book2);
        List<Book> expected = List.of(book1, book2, book3);


        // when
        Collection<Book> actual = sortBooksByAuthor(books);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void mergeCollections_should_return_new_collection() {
        // given
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", "Novel", 1813);
        Book book2 = new Book("Sanditon", "Jane Austen", "Novel", 1817);
        Book book3 = new Book("Friends, Lovers, and the Big Terrible Thing: A Memoir", "Matthew Perry", "Autobiography", 2022);


        List<Book> firstBookList = List.of(book1);
        List<Book> secondBookList = List.of(book2, book3);
        List<Book> expected = List.of(book1, book2, book3);

        // when
        Collection<Book> actual = mergeCollections(firstBookList, secondBookList);

        // then
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
    }
}
