package test;

import model.Element;
import model.Faktura;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;

public class TestFaktura {

    @Test
    public void kalkulatorFaktura(){
        Element element1 = new Element("produkt1",25,3);
        Element element2 = new Element("produkt2",12, 4);
        List<Element> elementy = new ArrayList<>();
        elementy.add(element1);
        elementy.add(element2);
        Faktura faktura = new Faktura(elementy);
        double netto = element1.wartoscNetto() + element2.wartoscNetto();
        double vat = element1.kwotaVat() + element2.kwotaVat();
        double brutto = element1.wartoscBrutto() + element2.wartoscBrutto();
        double[] testarray = {netto,vat,brutto};
        assertArrayEquals(testarray,faktura.kalkulator(),0.0001);
    }
}
