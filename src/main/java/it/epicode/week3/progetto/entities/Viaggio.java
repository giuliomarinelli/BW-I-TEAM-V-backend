package it.epicode.week3.progetto.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "viaggi")
public class Viaggio {
    @Id
    @GeneratedValue(generator = "viaggio_id_gen")
    @SequenceGenerator(name = "viaggio_id_gen", sequenceName =
            "viaggio_id_gen", schema = "public", initialValue = 1, allocationSize = 1)
    private int id;
    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    Tratta tratta;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    Mezzo mezzo;
    @Column(name = "orario_di_partenza")
    private LocalDateTime orarioDiPartenza; // corrisponde con l'orario in cui il biglietto è vidimato. Per adesso ho usato LocalDateTime, poi vedremo insieme come gestire la tipizzazione
    private int tempoEffettivoPercorrenza;  // in minuti, o meglio usare LocalTime?

    @OneToMany(mappedBy = "?")  // ho bisogno del nome della proprietà presente in TitoloDiViaggio che referenzia la relazione
    List<TitoloDiViaggio> titoliDiViaggio;


}
