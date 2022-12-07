package pl.biblioteka.domain;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NonNull;
import pl.biblioteka.enums.Category;


@Data

public class Book {
    @NonNull
    private String author;
    @NonNull
    private String title;
    private Category category;
    private boolean isBorrowed;
    private Client owner;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

}
