package it.epicode.week3.progetto.dao;

import it.epicode.week3.progetto.entities.TitoloDiViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TitoloDiViaggioDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public TitoloDiViaggioDAO(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void emettiTitolo(TitoloDiViaggio t){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(t);
        et.commit();
    }

    public TitoloDiViaggio getById(int id){
        return em.find(TitoloDiViaggio.class, id);
    }//

    public void eliminaTitolo(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        TitoloDiViaggio t = getById(id);
        em.remove(t);
        et.commit();
    }
}
