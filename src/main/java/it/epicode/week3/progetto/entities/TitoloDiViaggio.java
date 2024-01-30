package it.epicode.week3.progetto.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public abstract class TitoloDiViaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_titoli_di_viaggio")
    @SequenceGenerator(name = "sequenza_titoli_di_viaggio", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_emittente")
    private Emittente emittente;

    @Column(name = "data_emissione")
    private LocalDateTime dataEmissione;

    @Column(name = "data_attivazione")
    private LocalDateTime dataAttivazione;

    @Column(name = "data_scadenza")
    private LocalDateTime dataScadenza;

    @ManyToMany
    @JoinTable(
            name = "vidimazioni",
            joinColumns = @JoinColumn(name = "id_titolo_di_viaggio"),
            inverseJoinColumns = @JoinColumn(name = "id_viaggio")
    )
    private List<Viaggio> viaggi;

    public TitoloDiViaggio() {}

    public TitoloDiViaggio(int id, Emittente emittente, LocalDateTime dataEmissione, LocalDateTime dataAttivazione, List<Viaggio> viaggi) {
        this.id = id;
        this.emittente = emittente;
        this.dataEmissione = dataEmissione;
        this.dataAttivazione = dataAttivazione;
        dataScadenza = dataEmissione.plusYears(2);
        this.viaggi = viaggi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Emittente getEmittente() {
        return emittente;
    }

    public void setEmittente(Emittente emittente) {
        this.emittente = emittente;
    }

    public LocalDateTime getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDateTime dataEmissione) {
        this.dataEmissione = dataEmissione;
        dataScadenza = dataEmissione.plusYears(2);
    }

    public LocalDateTime getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(LocalDateTime dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public LocalDateTime getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDateTime dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(List<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", emittente=" + emittente +
                ", dataEmissione=" + dataEmissione +
                ", dataAttivazione=" + dataAttivazione +
                ", dataScadenza=" + dataScadenza +
                ", viaggi=" + viaggi +
                '}';
    }
}
