package os.sa.pituusvertailija.service;

import org.springframework.stereotype.Service;

import os.sa.pituusvertailija.domain.Esine;
import os.sa.pituusvertailija.domain.EsineRepository;

@Service
public class EsineService {

    private final EsineRepository esineRepository;

    public EsineService(EsineRepository esineRepository) {
        this.esineRepository = esineRepository;
    }

    public String vertaaPituus(Long id1, Long id2) {

        Esine esine1 = esineRepository.findById(id1).get();
        Esine esine2 = esineRepository.findById(id2).get();

        Double korkeus1 = esine1.getKorkeus();
        Double korkeus2 = esine2.getKorkeus();

        double kerroin = korkeus1 / korkeus2;

        return String.format("%s on noin %.2f kertaa %s:n korkuinen.", esine1.getNimi(), kerroin, esine2.getNimi());
    }
}
