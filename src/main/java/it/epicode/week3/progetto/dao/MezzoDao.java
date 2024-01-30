package it.epicode.week3.progetto.dao;

import it.epicode.week3.progetto.entities.Mezzo;
import jakarta.persistence.*;



public class MezzoDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public MezzoDao(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void save(MezzoDao m){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(m);

        et.commit();
    }

    public Mezzo getById(int id){
        return em.find(Mezzo.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Mezzo m = getById(id);
        em.remove(m);
        et.commit();
    }

    public void close(){
        em.close();
        emf.close();
    }

}
