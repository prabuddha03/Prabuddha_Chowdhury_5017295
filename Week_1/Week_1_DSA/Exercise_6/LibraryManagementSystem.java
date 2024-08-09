import java.util.Arrays;
import java.util.List;

class LibraryBook {
    private final int id;
    private final String title;
    private final String author;

    public LibraryBook(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "LibraryBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {

    public static LibraryBook findBookByTitleLinear(List<LibraryBook> libraryBooks, String title) {
        for (LibraryBook book : libraryBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static LibraryBook findBookByTitleBinary(List<LibraryBook> libraryBooks, String title) {
        int left = 0;
        int right = libraryBooks.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = libraryBooks.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return libraryBooks.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<LibraryBook> libraryBooks = Arrays.asList(
            new LibraryBook(1, "To Kill a Mockingbird", "Harper Lee"),
            new LibraryBook(2, "1984", "George Orwell"),
            new LibraryBook(3, "The Great Gatsby", "F. Scott Fitzgerald"),
            new LibraryBook(4, "Moby Dick", "Herman Melville"),
            new LibraryBook(5, "War and Peace", "Leo Tolstoy"),
            new LibraryBook(6, "Pride and Prejudice", "Jane Austen"),
            new LibraryBook(7, "The Catcher in the Rye", "J.D. Salinger")
        );

        String searchTitle = "1984";

        LibraryBook resultLinear = findBookByTitleLinear(libraryBooks, searchTitle);
        System.out.println("Linear Search Result: " + resultLinear);

        libraryBooks.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        LibraryBook resultBinary = findBookByTitleBinary(libraryBooks, searchTitle);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}
