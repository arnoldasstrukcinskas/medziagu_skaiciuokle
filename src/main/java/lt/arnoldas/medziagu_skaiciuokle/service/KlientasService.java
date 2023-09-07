package lt.arnoldas.medziagu_skaiciuokle.service;

import lt.arnoldas.medziagu_skaiciuokle.repository.KlientasRepository;
import lt.arnoldas.medziagu_skaiciuokle.repository.model.Klientas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class KlientasService {

    @Autowired
    private KlientasRepository klientasRepository;

    public String save(Klientas klientas){
        return klientasRepository.save(klientas).getKlientoId();
    }

    public List<Klientas> getAll() {
        return (List<Klientas>) klientasRepository.findAll();
    }

}
