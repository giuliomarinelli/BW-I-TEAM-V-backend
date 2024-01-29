package it.epicode.week3.progetto.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class Distributore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean attivo;


    public Distributore() {
    }

    public Distributore(Long id, boolean attivo, Emittente emittente) {
        this.id = id;
        this.attivo = attivo;
        this.emittente = emittente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public Emittente getEmittente() {
        return emittente;
    }

    public void setEmittente(Emittente emittente) {
        this.emittente = emittente;
    }

    @Override
    public String toString() {
        return "Distributore{" +
                "id=" + id +
                ", attivo=" + attivo +
                ", emittente=" + emittente +
                '}';
    }

    @JoinColumn(name = "emittente_id")
    private Emittente emittente;
}
