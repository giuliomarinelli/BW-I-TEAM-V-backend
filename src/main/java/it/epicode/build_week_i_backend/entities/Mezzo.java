package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_mezzo")
    @SequenceGenerator(name = "sequenza_mezzo", initialValue = 1, allocationSize = 1)
    private int id;
    private int capienza;
    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione> manutezioni;
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
    @OneToMany(mappedBy = "mezzo")
    private List<Viaggio> viaggi;

    public Mezzo(){

    }

    public Mezzo(int id, int capienza, List<Manutenzione> manutezioni, Tratta tratta, List<Viaggio> viaggi) {
        this.id = id;
        this.capienza = capienza;
        this.manutezioni = manutezioni;
        this.tratta = tratta;
        this.viaggi = viaggi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public List<Manutenzione> getManutezioni() {
        return manutezioni;
    }

    public void setManutezioni(List<Manutenzione> manutezioni) {
        this.manutezioni = manutezioni;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(List<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    @Override
    public String toString() {
        return "MezzoDiTrasporto{" +
                "id=" + id +
                ", capienza=" + capienza +
                ", manutezioni=" + manutezioni +
                ", tratta=" + tratta +
                ", viaggi=" + viaggi +
                '}';
    }
}


