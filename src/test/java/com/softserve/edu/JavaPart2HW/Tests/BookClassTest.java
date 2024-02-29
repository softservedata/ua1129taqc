package com.softserve.edu.JavaPart2HW.Tests;

import com.softserve.edu.JavaPart2HW.BookClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;


public class BookClassTest {

    @Test
    public void getBooksByGenre() {
        //Arrange
        var givenGenre = "Fantasy";
        var fantasyBook = new BookClass("Book", "Author", givenGenre, 2024);
        var notFantasyBook = new BookClass("Book", "Author", "NotFantasy", 2024);
        var books = new ArrayList<BookClass>();
        books.add(fantasyBook);
        books.add(notFantasyBook);

        //Act
        var fantasyBooks = BookClass.GetBooksByGenre(givenGenre, books);

        //Assert
        Assertions.assertEquals(1, fantasyBooks.size());
        Assertions.assertEquals(givenGenre, fantasyBooks.getFirst().getGenre());
        Assertions.assertEquals(fantasyBook, fantasyBooks.getFirst());
    }

    @Test
    public void CombineCollection() {
        //Arrange

        var dramaBook = new BookClass("Book", "Author", "Drama", 2024);
        var fantasyBook = new BookClass("Book", "Author", "Fantasy", 2024);
        ArrayList<BookClass> books = new ArrayList<>();
        books.add(dramaBook);
        ArrayList<BookClass> books2 = new ArrayList<>();
        books2.add(fantasyBook);

        //Act
        var combinedCollection = BookClass.GetCombinedCollection(books, books2);

        //Assert
        Assertions.assertEquals(2, combinedCollection.size());
        Assertions.assertTrue(combinedCollection.contains(dramaBook));
        Assertions.assertTrue(combinedCollection.contains(fantasyBook));
    }

    @Test
    public void GetAuthorByTitleTest(){
        //Arrange
        var dramaBook = new BookClass("Book", "Author", "Drama", 2024);
        var fantasyBook = new BookClass("Book1", "Steven King", "Fantasy", 2024);
        ArrayList<BookClass> books = new ArrayList<>();
        books.add(dramaBook);
        books.add(fantasyBook);

        //Act
        var title = "Book1";
        var author = BookClass.GetAuthorByTitle(title,books);

        //Asset
        Assertions.assertEquals("Steven King", author);
    }

    @Test
    public void GetAuthorByTitleReturnsNullIfNotFound(){
        //Arrange
        var dramaBook = new BookClass("Book", "Author", "Drama", 2024);
        var fantasyBook = new BookClass("Book1", "Steven King", "Fantasy", 2024);
        ArrayList<BookClass> books = new ArrayList<>();
        books.add(dramaBook);
        books.add(fantasyBook);

        //Act
        var title = "BookH";
        var author = BookClass.GetAuthorByTitle(title,books);

        //Assert
        Assertions.assertNull(author);
    }
}





