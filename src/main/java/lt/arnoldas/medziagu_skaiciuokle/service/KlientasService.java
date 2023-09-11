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

    public String save(Klientas klientas){                      // issaugo klienta
        return klientasRepository.save(klientas).getKlientoId();
    }

    public List<Klientas> getAll() {                           // paima visus klientus
        return (List<Klientas>) klientasRepository.findAll();
    }

    public List<Klientas> getKlientasByNameLike(String name){       //randa klienta pagal varda
        return klientasRepository.getKlientasByNameLike("%" + name + "%");
    }

    public Klientas getById(String id){                         // pagal tam tikra id randa klienta
        return klientasRepository.findById(id).get();
    }
}
