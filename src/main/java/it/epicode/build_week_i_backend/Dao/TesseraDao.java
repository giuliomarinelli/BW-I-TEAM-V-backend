package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.Tessera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TesseraDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public TesseraDao(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void saveTessera(Tessera u){
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(u);
            et.commit();
        }catch (NullPointerException e){
            e.getMessage();
            em.close();
        }


    }

    public Tessera getbyid(int id){
        return em.find(Tessera.class, id);
    }
    public void deleteTessera(int id){
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            Tessera u = getbyid(id);
            em.remove(u);
            et.commit();
        }catch (NullPointerException e){
            e.getMessage();
            em.close();
        }
    }
}
