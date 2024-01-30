package it.epicode.week3.progetto.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "distributori")
public class Distributore extends Emittente {

    private boolean attivo;


    public Distributore() {
    }

    public Distributore(Long id, String luogo, List<TitoloDiViaggio> titoli, boolean attivo) {
        super(id, luogo, titoli);
        this.attivo = attivo;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "attivo=" + attivo;
    }
}

