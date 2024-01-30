package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.Manutenzione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ManutenzioneDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ManutenzioneDAO(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void save(Manutenzione m){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(m);
        et.commit();
    }

    public Manutenzione getById(int id){
        return em.find(Manutenzione.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Manutenzione m = getById(id);
        em.remove(m);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }
}
