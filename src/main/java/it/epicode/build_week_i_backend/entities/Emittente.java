package it.epicode.build_week_i_backend.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Emittente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenza_emittenti")
    @SequenceGenerator(name = "sequenza_emittenti", initialValue = 1, allocationSize = 1)
    private int id;
    private String luogo;
    @OneToMany(mappedBy = "emittente")
    private List<TitoloDiViaggio> titoli;

    public Emittente() {
    }

    public Emittente(int id, String luogo, List<TitoloDiViaggio> titoli) {
        this.id = id;
        this.luogo = luogo;
        this.titoli = titoli;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public List<TitoloDiViaggio> getTitoli() {
        return titoli;
    }

    public void setTitoli(List<TitoloDiViaggio> titoli) {
        this.titoli = titoli;
    }

    public abstract boolean isActive();

    @Override
    public String toString() {
        return  "id=" + id +
                ", luogo='" + luogo + '\'' +
                ", titoli='" + titoli;
    }


}
