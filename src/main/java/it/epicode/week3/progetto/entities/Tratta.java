package it.epicode.week3.progetto.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "viaggi")
public class Tratta {
    @Id
    @GeneratedValue(generator = "tratta_id_gen")
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

    @OneToMany(mappedBy = "?") // Ho bisogno del nome della proprietà che referenzia la relazione
    private List<Viaggio> viaggi;


}
