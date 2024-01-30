package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.Emittente;
import jakarta.persistence.*;

public class EmittenteDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EmittenteDao() {
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void save(Emittente e){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
    }

    public Emittente getById(int id){
        return em.find(Emittente.class, id);
    }

    public void elimina(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Emittente e = getById(id);
        em.remove(e);
        et.commit();
    }
}
