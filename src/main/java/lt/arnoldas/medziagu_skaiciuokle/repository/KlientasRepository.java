package lt.arnoldas.medziagu_skaiciuokle.repository;

import jakarta.persistence.Entity;
import lt.arnoldas.medziagu_skaiciuokle.repository.model.Klientas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KlientasRepository extends CrudRepository<Klientas, Integer> {

    @Query(
            value = "SELECT * FROM klientai WHERE kliento_vardas LIKE :name",
            nativeQuery = true
    )
    List<Klientas> getKlientasByNameLike(String name);
}
