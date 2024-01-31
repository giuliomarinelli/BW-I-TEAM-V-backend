package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.Tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TrattaDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public TrattaDao() {
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void save(Tratta t) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(t);
            et.commit();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }

    public Tratta findOne(int id) {
        try {
            return em.find(Tratta.class, id);
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
        return null;
    }

    public void remove(int id) {
        Tratta t = findOne(id);
        if (t == null) {
            System.out.println("Si sta cercando di eliminare un elemento che non esiste");
            return;
        }
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(t);
            et.commit();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}
