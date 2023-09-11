package lt.arnoldas.medziagu_skaiciuokle.repository.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "klientai")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Klientas {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)     //UUDI kertasi su tipu, praso stringo, o duoda longa
    @UuidGenerator
    @Column(name = "kliento_id")
    private String klientoId;

    @Column(name = "kliento_vardas")
    private String klientoVardas;

    @Column(name = "kliento_pavarde")
    private String klientoPavarde;

    @Column(name = "elektroninis_pastas")
    private String elPastas;

    @Column(name = "salis")
    private String salis;

    @Column(name = "miestas")
    private String miestas;

    @OneToMany(mappedBy = "klientas", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Samata> samatos = new ArrayList<>();

}
