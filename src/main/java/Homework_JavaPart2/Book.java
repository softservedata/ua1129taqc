package Homework_JavaPart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(String title, String author, String genre, int year) {
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

    public static class BookCollection {

        private ArrayList<Book> books;

        public BookCollection() {
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void printListOfAuthors() {
            for (Book book : books) {
                System.out.println(book.getAuthor());
            }
        }

        public ArrayList<String> listAuthorsByGivenGenre(String givenGenre) {
            ArrayList<String> authorsList = new ArrayList<>();
            for (Book book : books) {
                if (book.getGenre().equalsIgnoreCase(givenGenre)) {
                    authorsList.add(book.getAuthor());
                }
            }
            return authorsList;
        }

        public void listAuthorsByPublicationYear(int givenYear) {
            for (Book book : books) {
                if (book.getYear() == givenYear) {
                    System.out.println(book.getAuthor());
                }
            }
        }

        public Book bookByGivenAuthor(String givenAuthor) {
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(givenAuthor)) {
                    return book;
                }
            }
            return null;
        }

        public ArrayList<Book> booksByGivenYear(int givenYear) {
            ArrayList<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.getYear() == givenYear) {
                    result.add(book);
                }
            }
            return result;
        }

        public ArrayList<Book> booksByGivenGenre(String givenGenre) {
            ArrayList<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.getGenre().equalsIgnoreCase(givenGenre)) {
                    result.add(book);
                }
            }
            return result;
        }

        public void removingSomeBooks(String givenAuthor) {
            books.removeIf(book -> book.getAuthor().equalsIgnoreCase(givenAuthor));
        }

        public void sortCollectionByCriterion(Comparator<Book> comparator) {
            Collections.sort(books, comparator);
        }

        public void combiningTwoBooks(BookCollection bookCollection2) {
            this.books.addAll(bookCollection2.books);
        }

        public ArrayList<Book> subcollectionOfBooks(String givenGenre) {
            ArrayList<Book> subcollection = new ArrayList<>();
            for (Book book : books) {
                if (book.getGenre().equalsIgnoreCase(givenGenre)) {
                    subcollection.add(book);
                }
            }
            return subcollection;
        }

    }
}
