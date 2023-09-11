package lt.arnoldas.medziagu_skaiciuokle.service;

import lt.arnoldas.medziagu_skaiciuokle.repository.KlientasRepository;
import lt.arnoldas.medziagu_skaiciuokle.repository.SamataRepository;
import lt.arnoldas.medziagu_skaiciuokle.repository.model.Klientas;
import lt.arnoldas.medziagu_skaiciuokle.repository.model.Samata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SamataService {

    @Autowired
    private SamataRepository samataRepository;

    @Autowired
    private KlientasRepository klientasRepository;

    public List<Samata> getAll() {
        return (List<Samata>) samataRepository.findAll();
    }

    public Object getSamataByStrukturaLike(String struktura) {
        return samataRepository.getSamataByStrukturaLike("%" + struktura + "%");
    }

    public void save(Samata samata, String klientoId){                      // issaugo samata
        if(klientasRepository.findById(klientoId).isPresent()) {
            Klientas klientas = klientasRepository.findById(klientoId).get();
            samata.setKlientas(klientas);
            samataRepository.save(samata);
        }
    }
}
