package service;

import model.Faktura;
import repository.FakturaRepo;

/**
 * Kod spełnia założenie niskiego sprzężenia.Stopień powiązania klas jest minimalny, wymagany do komunikacji.
 * FakturaService => FakturaRepo
 * Jednocześnie zachowuje się wysoką spójność przez przydzielenie grupie klas (FakturaService, FakturaRepo) realizacji zadań na bazie danych
 * Serwis spełnia zasade Pure Fabrication, klasa nie należy do klas dziedzinowych, ale poprzeż dodanie jej, odciążamy klase Faktury
 * zachowując niskie sprzężenie i wysoką spójność
 */
public class FakturaService {
    private final FakturaRepo fakturaRepo;

    public FakturaService(FakturaRepo fakturaRepo){
        this.fakturaRepo = fakturaRepo;
    }

    public void addFaktura(Faktura faktura){
        fakturaRepo.save(faktura);
    }

    public void removeFaktura(double id){
        fakturaRepo.remove(id);
    }

    public void updateFaktura(Faktura faktura){
        fakturaRepo.update(faktura);
    }

    public void showFaktura(double id){
        fakturaRepo.find(id);
    }

    public void showAll(){
        fakturaRepo.findAll();
    }

}
