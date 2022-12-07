package repository;

import model.Faktura;

import java.util.Collection;

/**
 * Klasa spełnia zasade dependency inversion
 * jest używana w serwisie, który operuje na tym abstrakcyjnym interfejsie
 */
public interface FakturaRepo {
    void save(Faktura faktura);
    void remove(double id);
    void update(Faktura faktura);
    Faktura find(double id);
    Collection<Faktura> findAll();
}
