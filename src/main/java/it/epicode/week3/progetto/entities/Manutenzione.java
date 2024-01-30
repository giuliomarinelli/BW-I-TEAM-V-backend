package it.epicode.week3.progetto.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Manutenzione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_manutenzioni")
    @SequenceGenerator(name = "sequenza_manutenzioni", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;

    @Column(name = "data_fine")
    private LocalDateTime datafine;

    public Manutenzione() {}

    public Manutenzione(int id, Mezzo mezzo, LocalDateTime dataInizio, LocalDateTime datafine) {
        this.id = id;
        this.mezzo = mezzo;
        this.dataInizio = dataInizio;
        this.datafine = datafine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDatafine() {
        return datafine;
    }

    public void setDatafine(LocalDateTime datafine) {
        this.datafine = datafine;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", mezzo=" + mezzo +
                ", dataInizio=" + dataInizio +
                ", datafine=" + datafine +
                '}';
    }
}
