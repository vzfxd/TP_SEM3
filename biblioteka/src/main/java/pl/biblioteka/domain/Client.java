package pl.biblioteka.domain;

import lombok.Data;
import lombok.NonNull;
import pl.biblioteka.exception.InvalidBook;
import java.util.ArrayList;
import java.util.List;

@Data
public class Client {
    @NonNull
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public void returnBook(final Book book) throws InvalidBook {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setBorrowDate(null);
            book.setBorrowed(false);
            book.setReturnDate(null);
            book.setOwner(null);
        } else {
            throw new InvalidBook("You do not have the book you are trying to return");
        }
    }

    public void setBorrowedBooks(final Book book) {
        borrowedBooks.add(book);
    }

    public String toString() {
        final StringBuilder books = new StringBuilder();
        for (final Book book: this.borrowedBooks) {
            books.append(book.getTitle());
        }
        return "name=" + this.name + " books=" + books;
    }
}
