package pl.biblioteka.domain;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class Employee {
    @NonNull
    private String name;

    public void assignBookToClient(final Client client, final Book book){
        book.setBorrowed(true);
        book.setOwner(client);
        book.setBorrowDate(LocalDateTime.now());
        book.setReturnDate(LocalDateTime.now().plusDays(14));
        client.setBorrowedBooks(book);
    }
}
