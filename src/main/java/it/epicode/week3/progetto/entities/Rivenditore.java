package it.epicode.week3.progetto.entities;

import jakarta.persistence.*;

public class Rivenditore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean aperto;

    public Rivenditore() {
    }

    public Rivenditore(Long id, boolean aperto, Emittente emittente) {
        this.id = id;
        this.aperto = aperto;
        this.emittente = emittente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAperto() {
        return aperto;
    }

    public void setAperto(boolean aperto) {
        this.aperto = aperto;
    }

    public Emittente getEmittente() {
        return emittente;
    }

    public void setEmittente(Emittente emittente) {
        this.emittente = emittente;
    }

    @Override
    public String toString() {
        return "Rivenditore{" +
                "id=" + id +
                ", aperto=" + aperto +
                ", emittente=" + emittente +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "emittente_id")
    private Emittente emittente;
}
