package model;

import lombok.Getter;

/**
 * Klasa element spełnia zasade GRASP Creator.
 * Klasa element jest odpowiedzialna za stworzenie obiektu klasy towar
 */
public class Element {
    private final Towar towar;
    @Getter
    private final int ilosc;

    public Element(String nazwa, double cena, int ilosc){
        towar = new Towar(nazwa,cena);
        this.ilosc = ilosc;
    }

    public double wartoscNetto(){ return ilosc * towar.getCenaNetto(); }

    public double kwotaVat(){ return wartoscNetto() * 0.23; }

    public double wartoscBrutto(){ return wartoscNetto() + kwotaVat(); }

    public String getTowarName(){ return towar.getNazwa(); }

    public Double getTowarCena() { return towar.getCenaNetto(); }

}
