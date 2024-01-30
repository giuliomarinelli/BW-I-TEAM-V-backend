package it.epicode.week3.progetto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table(name = "tram")
public class Tram extends Mezzo {

    public Tram(){

    }

    public Tram(int id, int capienza, List<Manutenzione> manutezioni, Tratta tratta, List<Viaggio> viaggi) {
        super(id, capienza, manutezioni, tratta, viaggi);
    }

    @Override
    public String toString() {
        return "Tram{} " + super.toString();
    }
}
