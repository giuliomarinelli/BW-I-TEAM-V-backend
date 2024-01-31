package it.epicode.build_week_i_backend.Dao;


import it.epicode.build_week_i_backend.entities.Manutenzione;
import it.epicode.build_week_i_backend.entities.TitoloDiViaggio;
import it.epicode.build_week_i_backend.entities.Viaggio;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;


public class ViaggioDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ViaggioDao() {
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void save(Viaggio v) {
        Query query = em.createQuery("SELECT m FROM Manutenzione m WHERE m.mezzo.id = :id");
        query.setParameter("id", v.getMezzo().getId());
        List<Manutenzione> lista = query.getResultList();
        lista = lista.stream().filter(m -> v.getOrarioDiPartenza().isAfter(m.getDataInizio()) && v.getOrarioDiPartenza().isBefore(m.getDatafine())).collect(Collectors.toList());
        if (lista.size() > 0) {
            System.out.println("Il mezzo scelto è in manutenzione");
            return;
        }
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(v);
            et.commit();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }

    public Viaggio findOne(int id) {
        try {
            return em.find(Viaggio.class, id);
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
        return null;
    }

    public void remove(int id) {
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
