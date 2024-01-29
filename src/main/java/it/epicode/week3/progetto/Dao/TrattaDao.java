package it.epicode.week3.progetto.Dao;

import it.epicode.week3.progetto.entities.Tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TrattaDao {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void open() {
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public static void close() {
        em.close();
        emf.close();
    }

    public static void save(Tratta t) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(t);
            et.commit();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }

    public static Tratta findOne(int id) {
        try {
            return em.find(Tratta.class, id);
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
        return null;
    }

    public static void remove(int id) {
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
