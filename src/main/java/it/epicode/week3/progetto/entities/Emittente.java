package it.epicode.week3.progetto.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Emittente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String luogo;
    private String titoli;

    public Emittente() {
    }

    public Emittente(Long id, String luogo, String titoli, List<Distributore> distributori, List<Rivenditore> rivenditori) {
        this.id = id;
        this.luogo = luogo;
        this.titoli = titoli;
        this.distributori = distributori;
        this.rivenditori = rivenditori;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getTitoli() {
        return titoli;
    }

    public void setTitoli(String titoli) {
        this.titoli = titoli;
    }

    public List<Distributore> getDistributori() {
        return distributori;
    }

    public void setDistributori(List<Distributore> distributori) {
        this.distributori = distributori;
    }

    public List<Rivenditore> getRivenditori() {
        return rivenditori;
    }

    public void setRivenditori(List<Rivenditore> rivenditori) {
        this.rivenditori = rivenditori;
    }

    @Override
    public String toString() {
        return "Emittente{" +
                "id=" + id +
                ", luogo='" + luogo + '\'' +
                ", titoli='" + titoli + '\'' +
                ", distributori=" + distributori +
                ", rivenditori=" + rivenditori +
                '}';
    }

    @OneToMany (mappedBy = "emittente")
    private List<Distributore> distributori;

    @OneToMany (mappedBy = "emittente")
    private List<Rivenditore> rivenditori;
}
