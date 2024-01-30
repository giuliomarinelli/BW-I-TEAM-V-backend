package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento extends TitoloDiViaggio{
    @Enumerated(EnumType.STRING)
    private DurataAbbonamento durata;

    @ManyToOne
    @JoinColumn(name = "id_tessera")
    private Tessera tessera;

    public Abbonamento(){}

    public Abbonamento(int id, Emittente emittente, LocalDateTime dataEmissione, LocalDateTime dataAttivazione, List<Viaggio> viaggi, DurataAbbonamento durata, Tessera tessera) {
        super(id, emittente, dataEmissione, dataAttivazione, viaggi);
        if (durata == DurataAbbonamento.SETTIMANALE) {
            setDataAttivazione(getDataAttivazione().plusDays(7));
        } else {
            setDataAttivazione(getDataAttivazione().plusDays(30));
        }
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
    public void setDataAttivazione(LocalDateTime dataAttivazione) {
        super.setDataAttivazione(dataAttivazione);
        if (durata == DurataAbbonamento.SETTIMANALE) {
            setDataAttivazione(getDataAttivazione().plusDays(7));
        } else {
            setDataAttivazione(getDataAttivazione().plusDays(30));
        }
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "durata=" + durata +
                ", tessera=" + tessera +
                '}';
    }
}
