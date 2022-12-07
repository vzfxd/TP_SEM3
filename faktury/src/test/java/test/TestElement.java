package test;

import model.Element;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestElement {

    @Test
    public void wartoscNetto() {
        double netto = 25.0;
        int ilosc = 2;
        Element element = new Element("produkt", netto, ilosc);
        assertEquals(netto * ilosc, element.wartoscNetto(), 0.0001);
    }

    @Test
    public void kwotaVat() {
        double netto = 25.0;
        int ilosc = 2;
        Element element = new Element("produkt", netto, ilosc);
        assertEquals(element.wartoscNetto() * 0.23, element.kwotaVat(), 0.0001);
    }

    @Test
    public void wartoscBrutto() {
        double netto = 25.0;
        int ilosc = 2;
        Element element = new Element("produkt", netto, ilosc);
        assertEquals(element.wartoscNetto() + element.kwotaVat(), element.wartoscBrutto(), 0.0001);
    }
}