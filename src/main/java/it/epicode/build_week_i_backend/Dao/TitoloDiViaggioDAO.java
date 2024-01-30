package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.TitoloDiViaggio;
import it.epicode.build_week_i_backend.entities.Viaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class TitoloDiViaggioDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public TitoloDiViaggioDAO(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void emettiTitolo(TitoloDiViaggio t){
        if (!t.getEmittente().isActive()) {
            System.out.println("L'emittente non è attivo");
            return;
        }
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(t);
        et.commit();
    }

    public TitoloDiViaggio getById(int id){
        return em.find(TitoloDiViaggio.class, id);
    }

    public void eliminaTitolo(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        TitoloDiViaggio t = getById(id);
        em.remove(t);
        et.commit();
    }

    public void vidimaTitolo(int id, Viaggio v){
        TitoloDiViaggio t = getById(id);
        if (t.getDataAttivazione() != null) {
            System.out.println("Il titolo di viaggio è già stato vidimato");
            return;
        }
        t.setDataAttivazione(LocalDateTime.now());
        EntityTransaction et = em.getTransaction();
        et.begin();
        t.getViaggi().add(v);
        em.persist(t);
        et.commit();
    }
}
