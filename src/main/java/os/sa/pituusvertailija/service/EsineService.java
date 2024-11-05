package os.sa.pituusvertailija.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import os.sa.pituusvertailija.domain.EsineRepository;

@Service
public class EsineService {

    private final EsineRepository esineRepository;

    @Autowired
    public EsineService(EsineRepository esineRepository) {
        this.esineRepository = esineRepository;
    }


}
