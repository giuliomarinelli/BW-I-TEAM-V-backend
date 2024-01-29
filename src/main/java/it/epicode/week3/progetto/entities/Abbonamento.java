package it.epicode.week3.progetto.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

public class Abbonamento extends TitoloDiViaggio{
    @Enumerated(EnumType.STRING)
    private DurataAbbonamento durata;

    @OneToMany
    @JoinColumn(name = "id_tessera")
    private Tessera tessera;

    public Abbonamento(){}

    public Abbonamento(int id, Emittente emittente, LocalDateTime dataEmissione, LocalDateTime dataAttivazione, List<Viaggio> viaggi, DurataAbbonamento durata, Tessera tessera) {
        super(id, emittente, dataEmissione, dataAttivazione, viaggi);
        this.durata = durata;
        this.tessera = tessera;
    }

    public DurataAbbonamento getDurata() {
        return durata;
    }

    public void setDurata(DurataAbbonamento durata) {
        this.durata = durata;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "durata=" + durata +
                ", tessera=" + tessera +
                '}';
    }
}
