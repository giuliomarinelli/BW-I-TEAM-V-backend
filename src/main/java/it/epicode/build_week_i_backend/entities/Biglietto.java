package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "biglietti")
public class Biglietto extends TitoloDiViaggio {
    @Column(name = "minuti_validita")
    private final int minutiValidita = 120;

    public Biglietto() {}

    public Biglietto(int id, Emittente emittente, LocalDateTime dataEmissione, LocalDateTime dataAttivazione, List<Viaggio> viaggi) {
        super(id, emittente, dataEmissione, dataAttivazione, viaggi);
        setDataScadenza(getDataAttivazione().plusMinutes(minutiValidita));
    }

    public int getMinutiValidita() {
        return minutiValidita;
    }

    @Override
    public void setDataAttivazione(LocalDateTime dataAttivazione) {
        super.setDataAttivazione(dataAttivazione);
        setDataScadenza(getDataAttivazione().plusMinutes(minutiValidita));
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "minutiValidita=" + minutiValidita +
                '}';
    }
}
