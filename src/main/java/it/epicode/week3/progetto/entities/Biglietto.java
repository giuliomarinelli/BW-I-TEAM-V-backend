package it.epicode.week3.progetto.entities;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class Biglietto extends TitoloDiViaggio{
    @Column(name = "minuti_validita")
    private int minutiValidita;

    public Biglietto() {}

    public Biglietto(int id, Emittente emittente, LocalDateTime dataEmissione, LocalDateTime dataAttivazione, List<Viaggio> viaggi) {
        super(id, emittente, dataEmissione, dataAttivazione, viaggi);
        this.minutiValidita = 120;
    }

    public int getMinutiValidita() {
        return minutiValidita;
    }

    public void setMinutiValidita(int minutiValidita) {
        this.minutiValidita = minutiValidita;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "minutiValidita=" + minutiValidita +
                '}';
    }
}
