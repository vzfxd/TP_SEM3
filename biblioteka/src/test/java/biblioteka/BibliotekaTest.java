package biblioteka;

import pl.biblioteka.domain.Book;
import pl.biblioteka.domain.Client;
import pl.biblioteka.domain.Employee;
import pl.biblioteka.exception.InvalidBook;

public class BibliotekaTest {
    public static void main(final String[] args) throws InvalidBook {

        final Book potopBook = new Book("Henryk Sienkiewicz","jakasKSiazka");
        final Book chlopiBook = new Book("Władysław Reymont","Chlopi");
        final Client mateuszClient = new Client("Mateusz");
        final Employee employee = new Employee("Pracownik");

        System.out.printf("## Przed wypożyczeniem ##\n %s || %s || %s\n",mateuszClient,potopBook,chlopiBook);

        employee.assignBookToClient(mateuszClient,potopBook);
        employee.assignBookToClient(mateuszClient,chlopiBook);

        System.out.printf("## Po wypożyczeniu ##\n %s || %s || %s\n",mateuszClient,potopBook,chlopiBook);

        mateuszClient.returnBook(potopBook);
        mateuszClient.returnBook(chlopiBook);

        System.out.printf("## Po oddaniu ##\n %s || %s || %s\n",mateuszClient,potopBook,chlopiBook);
    }
}
