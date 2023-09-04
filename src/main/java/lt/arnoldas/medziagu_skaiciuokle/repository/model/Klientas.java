package lt.arnoldas.medziagu_skaiciuokle.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "klientai")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Klientas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)     //generuoju random id, klientams
    @Column(name = "kliento_id")
    private Integer klientoId;

    @Column(name = "kliento_vardas")
    private String klietoVardas;

    @Column(name = "kliento_pavarde")
    private String klientoPavarde;

    @Column(name = "elektroninis_pastas")
    private String elPastas;

    @Column(name = "salis")
    private String salis;

    @Column(name = "miestas")
    private String miestas;

}
