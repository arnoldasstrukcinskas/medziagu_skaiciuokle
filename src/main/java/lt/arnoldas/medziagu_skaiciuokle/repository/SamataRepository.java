package lt.arnoldas.medziagu_skaiciuokle.repository;

import lt.arnoldas.medziagu_skaiciuokle.repository.model.Klientas;
import lt.arnoldas.medziagu_skaiciuokle.repository.model.Samata;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SamataRepository extends CrudRepository<Samata, Integer> {

    @Query(
            value = "SELECT * FROM samatos WHERE struktura LIKE :struktura",
            nativeQuery = true
    )
    List<Klientas> getSamataByStrukturaLike(String struktura);
}
