package lt.arnoldas.medziagu_skaiciuokle.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "samatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Samata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //generuoju id didejancius po viena
    @Column(name = "samatos_id")
    private Integer samatosId;

    @Column(name = "struktura")
    private String struktura;

    @Column(name = "strukturos_aukstis")
    private Double strukturosAukstis;

    @Column(name = "strukturos_ilgis")
    private Double strukturosIlgis;

    @Column(name = "strukturos_plotis")
    private Double strukturosPlotis;

    @Column(name = "medziaga")
    private String medziaga;

    @Column(name = "medziagos_ilgis")
    private Double medziagosIlgis;

    @Column(name = "medziagos_plotis")
    private Double medziagosPlotis;

    @Column(name = "medziagos_aukstis")
    private Double medziagosAukstis;

    @Column(name = "vienetai")
    private Integer vienetai;

    @Column(name = "plotas")
    private Double plotas;

    @Column(name = "turis")
    private Double turis;

    @ManyToOne
    @JoinColumn(name = "kliento_id", nullable = false)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private Klientas klientas;
}
