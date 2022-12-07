package model;

import java.util.List;

/**
 * Klasa Faktura spełnia zasade GRASP Expert.
 * Klasa Faktura jest odpowiedzialna za wyliczenie całkowitych wartości brutto,netto, ponieważ ma wszstkie potrzebne informacje.
 * Kod spełnia założenie niskiego sprzężenia.Stopień powiązania klas jest minimalny, wymagany do komunikacji.
 * Faktura => Element => Towar.
 * Jednocześnie zachowuje się wysoką spójność przez przydzielenie grupie klas (element,faktura,towar) realizacji zadań do faktury
 */
public class Faktura {

    private double id;
    private final List<Element> elementy;
    private double calkowityVat;
    private double calkowiteNetto;
    private double calkowiteBrutto;

    public Faktura(List<Element> elementy){
        this.elementy = elementy;
        calkowiteNetto = kalkulator()[0];
        calkowityVat = kalkulator()[1];
        calkowiteBrutto = kalkulator()[2];
    }

    public double[] kalkulator(){
        double netto = 0;
        double vat = 0;
        double brutto = 0;
        for(Element element: elementy){
            brutto += element.wartoscBrutto();
            netto += element.wartoscNetto();
            vat += element.kwotaVat();
        }
        return new double[]{netto,vat,brutto};
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Element element: elementy){
            stringBuilder.append(element.getTowarName()).append(" || ");
            stringBuilder.append(element.getIlosc()).append(" szt. || ");
            stringBuilder.append(element.getTowarCena()).append(" (cena netto) || ");
            stringBuilder.append(element.wartoscNetto()).append(" (wartosc netto) || ");
            stringBuilder.append(element.kwotaVat()).append(" (kwota vat) || ");
            stringBuilder.append(element.wartoscBrutto()).append(" (wartosc brutto) ||\n");
        }
        stringBuilder.append("RAZEM ||");
        stringBuilder.append("wartosc netto == ").append(calkowiteNetto).append(" || ");
        stringBuilder.append("kwota vat == ").append(calkowityVat).append(" || ");
        stringBuilder.append("wartosc brutto == ").append(calkowiteBrutto).append("\n");

        return stringBuilder.toString();
    }
}
