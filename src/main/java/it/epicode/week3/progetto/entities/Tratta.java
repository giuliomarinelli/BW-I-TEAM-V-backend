package it.epicode.week3.progetto.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tratte")
public class Tratta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tratta_id_gen")
    @SequenceGenerator(name = "tratta_id_gen", sequenceName =
    "tratta_id_gen", schema = "public", initialValue = 1, allocationSize = 1)
    private int id;
    @Column(name = "zona_partenza")
    private String zonaPartenza;

    @Column(name = "zona_arrivo")
    private String zonaArrivo;

    @Column(name = "tempo_medio_percorrenza")
    private int tempoMedioPercorrenza; // in minuti, o meglio usare LocalTime?

    @OneToMany(mappedBy = "tratta")
    private List<Mezzo> mezzi;

//    @OneToMany(mappedBy = "") // Ho bisogno del nome della proprietà che referenzia la relazione
//    private List<Tratta> viaggi;

    public Tratta() {}

    public Tratta(int id, String zonaPartenza, String zonaArrivo, int tempoMedioPercorrenza, List<Mezzo> mezzi, List<Viaggio> viaggi) {
        this.id = id;
        this.zonaPartenza = zonaPartenza;
        this.zonaArrivo = zonaArrivo;
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
        this.mezzi = mezzi;
        this.viaggi = viaggi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getZonaArrivo() {
        return zonaArrivo;
    }

    public void setZonaArrivo(String zonaArrivo) {
        this.zonaArrivo = zonaArrivo;
    }

    public int getTempoMedioPercorrenza() {
        return tempoMedioPercorrenza;
    }

    public void setTempoMedioPercorrenza(int tempoMedioPercorrenza) {
        this.tempoMedioPercorrenza = tempoMedioPercorrenza;
    }

    public List<Mezzo> getMezzi() {
        return mezzi;
    }

    public void setMezzi(List<Mezzo> mezzi) {
        this.mezzi = mezzi;
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(List<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", zonaArrivo='" + zonaArrivo + '\'' +
                ", tempoMedioPercorrenza=" + tempoMedioPercorrenza +
                ", mezzi=" + mezzi +
                ", viaggi=" + viaggi +
                '}';
    }
}
