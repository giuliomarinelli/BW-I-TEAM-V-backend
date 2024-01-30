package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@Table(name = "autobus")
public class Autobus extends Mezzo {


    public Autobus (){

    }

    public Autobus(int id, int capienza, List<Manutenzione> manutezioni, Tratta tratta, List<Viaggio> viaggi) {
        super(id, capienza, manutezioni, tratta, viaggi);
    }

    @Override
    public String toString() {
        return "Autobus{} " + super.toString();
    }
}
