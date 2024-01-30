package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rivenditori")
public class Rivenditore extends Emittente {


    private boolean aperto;

    public Rivenditore() {
    }

    public Rivenditore(int id, String luogo, List<TitoloDiViaggio> titoli, boolean aperto) {
        super(id, luogo, titoli);
        this.aperto = aperto;
    }

    public boolean isAperto() {
        return aperto;
    }

    public void setAperto(boolean aperto) {
        this.aperto = aperto;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", aperto=" + aperto;
    }
}
