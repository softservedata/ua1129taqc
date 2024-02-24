import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BookClass {
    String title;
    String author;
    String genre;
    int year;

    public BookClass(String title, String author, String genre, int year) {
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
        ArrayList<BookClass> books = new ArrayList<>();
        books.add(new BookClass("Book1", "Author1", "Fiction", 2000));
        books.add(new BookClass("Book2", "Author2", "Non-fiction", 2010));
        books.add(new BookClass("Book3", "Author1", "Fantasy", 2015));
        books.add(new BookClass("Book4", "Author3", "Science", 2005));

        ArrayList<BookClass> books2 = new ArrayList<>();
        books2.add(new BookClass("Book1", "Author1", "Fiction", 2000));
        books2.add(new BookClass("Book2", "Author2", "Non-fiction", 2010));
        books2.add(new BookClass("Book3", "Author1", "Fantasy", 2015));
        books2.add(new BookClass("Book4", "Author3", "Science", 2005));

        String givenGenre = "Fantasy";

        // Create a subcollection of books from the given genre
        ArrayList<BookClass> subCollection = new ArrayList<>();
        for (BookClass book : books) {
            if (book.getGenre().equalsIgnoreCase(givenGenre)) {
                subCollection.add(book);
            }
        }

        // Print the subcollection
        System.out.println("Subcollection of books from the genre " + givenGenre + ":");
        for (BookClass book : subCollection) {
            System.out.println(book.getTitle() + " - " + book.getAuthor());
        }

        // Combine the two collections into one
        ArrayList<BookClass> combinedCollection = new ArrayList<>(books);
        combinedCollection.addAll(books2);

        // Print the combined collection
        System.out.println("Combined collection:");
        for (BookClass book : combinedCollection) {
            System.out.println(book.getTitle() + " - " + book.getAuthor());
        }

        Collections.sort(books, new Comparator<BookClass>() {
            @Override
            public int compare(BookClass book1, BookClass book2) {
                return Integer.compare(book1.getYear(), book2.getYear());
            }
        });

        System.out.println("Sorted collection by year:");
        for (BookClass book : books) System.out.println(book.getTitle() + " - " + book.getYear());

        System.out.println("Author who have written Book4:");
        for (BookClass book : books)
            if (book.getTitle().equalsIgnoreCase("Book4")) {
                System.out.println(book.getAuthor());
            }

        System.out.println("List of Authors who have written books in 2015:");
        for (BookClass book : books)
            if (book.getYear()==2015) {
                System.out.println(book.getAuthor());
            }

        System.out.println("List of Authors who have written books in Fiction genre:");
        for (BookClass book : books)
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println(book.getAuthor());
            }

        System.out.println("List of Authors:");
        for (BookClass book : books) {
            System.out.println(book.getAuthor());



        }
    }
}