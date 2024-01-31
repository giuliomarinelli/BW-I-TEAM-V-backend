package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UtenteDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UtenteDao(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void saveUtente(Utente u){
        try{
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(u);
        et.commit();
        }catch (NullPointerException e){
            e.getMessage();
            em.close();
            emf.close();
        }
    }

    public Utente getbyid(int id){
        return em.find(Utente.class, id);
    }
        public void deleteUtente(int id){
        try{
        EntityTransaction et = em.getTransaction();
            et.begin();
            Utente u = getbyid(id);
            em.remove(u);
            et.commit();
        }catch (NullPointerException e){
            e.getMessage();
        }finally {
            em.close();
        }
        }

}
