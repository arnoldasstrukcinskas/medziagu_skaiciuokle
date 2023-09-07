package lt.arnoldas.medziagu_skaiciuokle.service;

import lt.arnoldas.medziagu_skaiciuokle.repository.SamataRepository;
import lt.arnoldas.medziagu_skaiciuokle.repository.model.Samata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SamataService {

    @Autowired
    private SamataRepository samataRepository;

    public List<Samata> getAll() {
        return (List<Samata>) samataRepository.findAll();
    }

    public Object getSamataByStrukturaLike(String struktura) {
        return samataRepository.getSamataByStrukturaLike("%" + struktura + "%");
    }
}
