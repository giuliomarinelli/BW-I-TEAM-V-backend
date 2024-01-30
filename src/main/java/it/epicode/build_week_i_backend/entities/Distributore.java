package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "distributori")
public class Distributore extends Emittente {

    private boolean attivo;


    public Distributore() {
    }

    public Distributore(int id, String luogo, List<TitoloDiViaggio> titoli, boolean attivo) {
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
    public boolean isActive() {
        return attivo;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "attivo=" + attivo;
    }
}

