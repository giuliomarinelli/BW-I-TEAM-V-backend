package it.epicode.week3.progetto.Dao;


import it.epicode.week3.progetto.entities.Viaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ViaggioDao {
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

    public static void save(Viaggio v) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(v);
            et.commit();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }

    public static Viaggio findOne(int id) {
        try {
            return em.find(Viaggio.class, id);
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
        return null;
    }

    public static void remove(int id) {
        Viaggio v = findOne(id);
        if (v == null) {
            System.out.println("Si sta cercando di eliminare un elemento che non esiste");
            return;
        }
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(v);
            et.commit();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}
