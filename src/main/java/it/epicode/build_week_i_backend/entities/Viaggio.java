package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "viaggi")
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "viaggio_id_gen")
    @SequenceGenerator(name = "viaggio_id_gen", sequenceName =
            "viaggio_id_gen", schema = "public", initialValue = 1, allocationSize = 1)
    private int id;
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    Tratta tratta;

    @ManyToMany(mappedBy = "viaggi")
    private List<TitoloDiViaggio> titoliDiViaggio;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    @Column(name = "orario_di_partenza")
    private LocalDateTime orarioDiPartenza; // corrisponde con l'orario in cui il biglietto è vidimato. Per adesso ho usato LocalDateTime, poi vedremo insieme come gestire la tipizzazione
    @Column(name = "tempo_effettivo_percorrenza")
    private int tempoEffettivoPercorrenza;  // in minuti, o meglio usare LocalTime?


    public Viaggio() {}

    public Viaggio(int id, Tratta tratta, Mezzo mezzo, LocalDateTime orarioDiPartenza, int tempoEffettivoPercorrenza, List<TitoloDiViaggio> titoliDiViaggio) {
        this.id = id;
        this.tratta = tratta;
        this.mezzo = mezzo;
        this.orarioDiPartenza = orarioDiPartenza;
        this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
        this.titoliDiViaggio = titoliDiViaggio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDateTime getOrarioDiPartenza() {
        return orarioDiPartenza;
    }

    public void setOrarioDiPartenza(LocalDateTime orarioDiPartenza) {
        this.orarioDiPartenza = orarioDiPartenza;
    }

    public int getTempoEffettivoPercorrenza() {
        return tempoEffettivoPercorrenza;
    }

    public void setTempoEffettivoPercorrenza(int tempoEffettivoPercorrenza) {
        this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
    }

    public List<TitoloDiViaggio> getTitoliDiViaggio() {
        return titoliDiViaggio;
    }

    public void setTitoliDiViaggio(List<TitoloDiViaggio> titoliDiViaggio) {
        this.titoliDiViaggio = titoliDiViaggio;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", tratta=" + tratta +
                ", mezzo=" + mezzo +
                ", orarioDiPartenza=" + orarioDiPartenza +
                ", tempoEffettivoPercorrenza=" + tempoEffettivoPercorrenza +
                ", titoliDiViaggio=" + titoliDiViaggio +
                '}';
    }
}
