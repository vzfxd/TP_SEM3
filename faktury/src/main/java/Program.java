import model.Element;
import model.Faktura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String answer = zapytanie("[1] Stwórz fakture " + " [2] Zakończ program ");
        while(answer.equals("1")){
            List<Element> elements = new ArrayList<>();
            String towarAnswer = zapytanie("[1] Dodaj Towar " + " [2] Wyświetl fakture ");
            while(towarAnswer.equals("1")){
                System.out.println("Podaj nazwę towaru");
                String nazwa = scanner.nextLine();
                System.out.println("Podaj cene towaru");
                double cena = scanner.nextDouble();
                System.out.println("Podaj liczbe sztuk");
                int liczba = scanner.nextInt();
                scanner.nextLine();
                Element element = new Element(nazwa,cena,liczba);
                elements.add(element);
                towarAnswer = zapytanie("[1] Dodaj Towar " + "\n[2] Wyświetl fakture ");
            }
            Faktura faktura = new Faktura(elements);
            System.out.println(faktura);
            answer = zapytanie("[1] Stwórz fakture " + "\n[2] Zakończ program ");
        }

    }

    public static String zapytanie(String zapytanie){
        System.out.println(zapytanie);
        return scanner.nextLine();
    }
}
