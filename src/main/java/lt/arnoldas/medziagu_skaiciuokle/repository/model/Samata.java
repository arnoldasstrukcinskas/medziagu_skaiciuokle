package lt.arnoldas.medziagu_skaiciuokle.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "samatos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Samata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //generuoju id didejancius po viena
    @Column(name = "samatos_id")
    private Integer samatosId;

    @Column(name = "struktura")
    private String struktura;

    @Column(name = "strukturos_aukstis")
    private double strukturosAukstis;

    @Column(name = "strukturos_ilgis")
    private double strukturosIlgis;

    @Column(name = "strukturos_plotis")
    private double strukturosPlotis;

    @Column(name = "medziaga")
    private String medziaga;

    @Column(name = "medziagos_ilgis")
    private double medziagosIlgis;

    @Column(name = "medziagos_plotis")
    private double medziagosPlotis;

    @Column(name = "medziagos_aukstis")
    private double medziagosAukstis;

    @Column(name = "vienetai")
    private Integer vienetai;

    @Column(name = "kvadratūra")
    private double kvadratura;

    @Column(name = "kubatūra")
    private double kubatura;

    @ManyToOne
    @JoinColumn(name = "kliento_id", nullable = false)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private Klientas klientas;

    public Samata(String struktura, Double strukturosAukstis, Double strukturosIlgis, Double strukturosPlotis, String medziaga, Double medziagosIlgis, Double medziagosPlotis, Double medziagosAukstis, Integer vienetai, Double kvadratura, Double kubatura, Klientas klientas) {
        this.struktura = struktura;
        this.strukturosAukstis = strukturosAukstis;
        this.strukturosIlgis = strukturosIlgis;
        this.strukturosPlotis = strukturosPlotis;
        this.medziaga = medziaga;
        this.medziagosIlgis = medziagosIlgis;
        this.medziagosPlotis = medziagosPlotis;
        this.medziagosAukstis = medziagosAukstis;
        this.vienetai = vienetai;
        this.kvadratura = kvadratura;
        this.kubatura = kubatura;
        this.klientas = klientas;
    }

    public double calculateStrukturosKvadratura(double strukturosAukstis, double strukturosIlgis){
        double kvadratura = 0;
        if(strukturosAukstis != 0 && strukturosIlgis != 0) {
            kvadratura = strukturosAukstis * strukturosIlgis;
        }
        return kvadratura;
    }

    public double calculateStrukturosKubatura(double strukturosAukstis, double strukturosIlgis, double strukturosPlotis){
        double kubatura = 0;
        if(strukturosAukstis != 0 && strukturosIlgis != 0 && strukturosPlotis != 0) {
            kubatura = strukturosIlgis * strukturosAukstis * strukturosPlotis;
        }
        return kubatura;
    }
    public double calculateMedziagosKvadratura(double medziagosAukstis, double medziagosIlgis){
        double kvadratura = 0;
        if(medziagosAukstis != 0 && medziagosIlgis != 0){
           kvadratura = medziagosAukstis * medziagosIlgis;
        }
        return kvadratura;
    }

    public double calculateMedziagosKubatura(double medziagosAukstis, double medziagosIlgis, double medziagosPlotis){
        double kubatura = 0;
        if(medziagosAukstis != 0 && medziagosIlgis != 0 && medziagosPlotis != 0) {
            kubatura = medziagosIlgis * medziagosAukstis * medziagosPlotis;
        }
        return kubatura;
    }

    public double calculateVienetai(){
        double strukturosKvadratura = calculateStrukturosKvadratura(this.strukturosAukstis, this.strukturosIlgis);
        double medziagosKvadratura = calculateMedziagosKvadratura(this.medziagosAukstis, this.medziagosIlgis);
        double strukturosKubatura = calculateStrukturosKubatura(this.strukturosAukstis, this.strukturosIlgis, this.strukturosPlotis);
        double medziagosKubatura = calculateMedziagosKubatura(this.medziagosAukstis, this.medziagosIlgis, this.medziagosPlotis);
        int vienetai = 0;
        if(strukturosKvadratura != 0) {
            vienetai = (int) (strukturosKvadratura / medziagosKvadratura);
            vienetai = vienetai + (vienetai * 5 / 100);
        } else {
            vienetai =(int) (strukturosKubatura / medziagosKubatura);
            vienetai = vienetai + (vienetai * 5 / 100);
        }
        return vienetai;
    }
}
