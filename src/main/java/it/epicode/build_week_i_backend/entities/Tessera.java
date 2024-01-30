package it.epicode.build_week_i_backend.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tessera")
public class Tessera {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequenza_tessere", initialValue = 1, allocationSize = 1)
    private int id;

    @Column(name = "data_emissione_o-rinnovo")
    private LocalDate dataEmissioneORinnovo;

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    @OneToOne
    @JoinColumn(name = "utente_fk")
    private Utente utente;

    @OneToMany(mappedBy = "tessera")// cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    List<Abbonamento> abbonamenti;

    public Tessera(LocalDate dataEmissioneORinnovo, LocalDate dataScadenza, Utente utente, List<Abbonamento> abbonamenti) {
        this.dataEmissioneORinnovo = dataEmissioneORinnovo;
        this.dataScadenza = dataScadenza;
        this.utente = utente;
        this.abbonamenti = abbonamenti;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", dataEmissioneORinnovo=" + dataEmissioneORinnovo +
                ", dataScadenza=" + dataScadenza +
                ", utente=" + utente +
                ", abbonamenti=" + abbonamenti +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmissioneORinnovo() {
        return dataEmissioneORinnovo;
    }

    public void setDataEmissioneORinnovo(LocalDate dataEmissioneORinnovo) {
        this.dataEmissioneORinnovo = dataEmissioneORinnovo;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }
}
