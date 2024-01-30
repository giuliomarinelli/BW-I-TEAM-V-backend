package it.epicode.week3.progetto.dao;

import it.epicode.week3.progetto.entities.Autobus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AutobusDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public AutobusDao(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void save(AutobusDao a){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(a);

        et.commit();
    }

    public Autobus getById(int id){
        return em.find(Autobus.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Autobus a = getById(id);
        em.remove(a);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }
}
